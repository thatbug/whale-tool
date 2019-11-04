package org.thatbug.whale.core.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 简化测试
 *
 * @author qzl
 * @date 16:37 2019/9/17
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public @interface WhaleBootTest {
    /**
     * 服务名：appName
     * @return appName
     */
    @AliasFor("appName")
    String value() default "whale-test";
    /**
     * 服务名：appName
     * @return appName
     */
    @AliasFor("value")
    String appName() default "whale-test";
    /**
     * profile
     * @return profile
     */
    String profile() default "dev";
    /**
     * 启用 ServiceLoader 加载 launcherService
     * @return 是否启用
     */
    boolean enableLoader() default false;
}
