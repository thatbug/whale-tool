package org.thatbug.whale.core.boot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.thatbug.whale.core.launch.constant.AppConstant;

/**
 * MybatisPlusConfiguration
 *
 * @author qzl
 * @date 17:29 2019/9/19
 */
@Configuration
@MapperScan("org.thatbug.whale.**.mapper.**")
public class MybatisPlusConfiguration {

    @Bean
    @ConditionalOnMissingBean(PaginationInterceptor.class)
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件
     *
     * @return PerformanceInterceptor
     */
    @Bean
    @Profile({AppConstant.DEV_CODE, AppConstant.TEST_CODE})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
