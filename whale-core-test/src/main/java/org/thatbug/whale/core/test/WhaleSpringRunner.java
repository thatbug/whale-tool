package org.thatbug.whale.core.test;

import org.junit.runners.model.InitializationError;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thatbug.whale.core.launch.WhaleApplication;
import org.thatbug.whale.core.launch.constant.AppConstant;
import org.thatbug.whale.core.launch.constant.NacosConstant;
import org.thatbug.whale.core.launch.constant.SentinelConstant;
import org.thatbug.whale.core.launch.service.LauncherService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 设置启动参数
 *
 * @author qzl
 * @date 16:37 2019/9/17
 */
public class WhaleSpringRunner extends SpringJUnit4ClassRunner {

    public WhaleSpringRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
        setUpTestClass(clazz);
    }

    private void setUpTestClass(Class<?> clazz) {
        WhaleBootTest whaleBootTest = AnnotationUtils.getAnnotation(clazz, WhaleBootTest.class);
        if (whaleBootTest == null) {
            throw new WhaleBootTestException(String.format("%s must be @WhaleBootTest .", clazz));
        }
        String appName = whaleBootTest.appName();
        String profile = whaleBootTest.profile();
        boolean isLocalDev = WhaleApplication.isLocalDev();
        Properties props = System.getProperties();
        props.setProperty("whale.env", profile);
        props.setProperty("whale.name", appName);
        props.setProperty("whale.is-local", String.valueOf(isLocalDev));
        props.setProperty("whale.dev-mode", profile.equals(AppConstant.PROD_CODE) ? "false" : "true");
        props.setProperty("whale.service.version", AppConstant.APPLICATION_VERSION);
        props.setProperty("spring.application.name", appName);
        props.setProperty("spring.profiles.active", profile);
        props.setProperty("info.version", AppConstant.APPLICATION_VERSION);
        props.setProperty("info.desc", appName);
        props.setProperty("spring.cloud.nacos.discovery.server-addr", NacosConstant.NACOS_ADDR);
        props.setProperty("spring.cloud.nacos.config.server-addr", NacosConstant.NACOS_ADDR);
        props.setProperty("spring.cloud.nacos.config.prefix", NacosConstant.NACOS_CONFIG_PREFIX);
        props.setProperty("spring.cloud.nacos.config.file-extension", NacosConstant.NACOS_CONFIG_FORMAT);
        props.setProperty("spring.cloud.sentinel.transport.dashboard", SentinelConstant.SENTINEL_ADDR);
        props.setProperty("spring.main.allow-bean-definition-overriding", "true");
        // 加载自定义组件
        if (whaleBootTest.enableLoader()) {
            List<LauncherService> launcherList = new ArrayList<>();
            SpringApplicationBuilder builder = new SpringApplicationBuilder(clazz);
            ServiceLoader.load(LauncherService.class).forEach(launcherList::add);
            launcherList.stream().sorted(Comparator.comparing(LauncherService::getOrder)).collect(Collectors.toList())
                    .forEach(launcherService -> launcherService.launcher(builder, appName, profile));
        }
        System.err.println(String.format("---[junit.test]:[%s]---启动中，读取到的环境变量:[%s]", appName, profile));
    }

}

