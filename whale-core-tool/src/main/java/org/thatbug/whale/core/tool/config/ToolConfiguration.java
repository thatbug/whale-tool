package org.thatbug.whale.core.tool.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thatbug.whale.core.tool.support.xss.XssProperties;
import org.thatbug.whale.core.tool.utils.SpringUtil;

/**
 * 工具配置类
 *
 * @author qzl
 * @date 14:17 2019/9/17
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(XssProperties.class)
public class ToolConfiguration implements WebMvcConfigurer {

    /**
     * Spring上下文缓存
     *
     * @return SpringUtil
     */
    @Bean
    public SpringUtil springUtils() {
        return new SpringUtil();
    }

}
