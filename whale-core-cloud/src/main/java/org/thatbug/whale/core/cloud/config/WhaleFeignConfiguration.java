package org.thatbug.whale.core.cloud.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thatbug.whale.core.cloud.feign.FeignHystrixConcurrencyStrategy;
import org.thatbug.whale.core.cloud.feign.WhaleFeignRequestHeaderInterceptor;

/**
 * web配置
 *
 * @author qzl
 * @date 9:39 2019/9/17
 */
@Slf4j
@Configuration
@EnableCaching
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WhaleFeignConfiguration implements WebMvcConfigurer {

    @Bean
    @ConditionalOnMissingBean
    public RequestInterceptor requestInterceptor() {
        return new WhaleFeignRequestHeaderInterceptor();
    }

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }

}
