package org.thatbug.whale.core.boot.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.thatbug.whale.core.launch.props.WhaleProperties;
import org.thatbug.whale.core.tool.constant.SystemConstant;

/**
 * 配置类
 *
 * @author qzl
 * @date 16:55 2019/9/19
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({
        WhaleProperties.class
})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@AllArgsConstructor
public class WhaleBootAutoConfiguration {

    private WhaleProperties whaleProperties;

    /**
     * 全局变量定义
     */
    @Bean
    public SystemConstant fileConst() {
        SystemConstant me = SystemConstant.me();

        //设定开发模式
        me.setDevMode(("dev".equals(whaleProperties.getEnv())));

        //设定文件上传远程地址
        me.setDomain(whaleProperties.get("upload-domain", "http://localhost:8888"));

        //设定文件上传是否为远程模式
        me.setRemoteMode(whaleProperties.getBoolean("remote-mode", true));

        //远程上传地址
        me.setRemotePath(whaleProperties.get("remote-path", System.getProperty("user.dir") + "/work/blade"));

        //设定文件上传头文件夹
        me.setUploadPath(whaleProperties.get("upload-path", "/upload"));

        //设定文件下载头文件夹
        me.setDownloadPath(whaleProperties.get("download-path", "/download"));

        //设定上传图片是否压缩
        me.setCompress(whaleProperties.getBoolean("compress", false));

        //设定上传图片压缩比例
        me.setCompressScale(whaleProperties.getDouble("compress-scale", 2.00));

        //设定上传图片缩放选择:true放大;false缩小
        me.setCompressFlag(whaleProperties.getBoolean("compress-flag", false));

        return me;
    }

}
