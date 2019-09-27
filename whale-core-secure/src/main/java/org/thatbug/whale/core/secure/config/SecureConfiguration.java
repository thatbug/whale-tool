package org.thatbug.whale.core.secure.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thatbug.whale.core.secure.aspect.AuthAspect;
import org.thatbug.whale.core.secure.interceptor.ClientInterceptor;
import org.thatbug.whale.core.secure.interceptor.SecureInterceptor;
import org.thatbug.whale.core.secure.props.WhaleClientProperties;
import org.thatbug.whale.core.secure.props.WhaleSecureProperties;
import org.thatbug.whale.core.secure.provider.ClientDetailsServiceImpl;
import org.thatbug.whale.core.secure.provider.IClientDetailsService;
import org.thatbug.whale.core.secure.registry.SecureRegistry;

/**
 * 安全配置类
 *
 * @author qzl
 * @date 15:15 2019/9/17
 */
@Order
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties({WhaleSecureProperties.class, WhaleClientProperties.class})
public class SecureConfiguration implements WebMvcConfigurer {

    private final SecureRegistry secureRegistry;

    private final WhaleSecureProperties secureProperties;

    private final WhaleClientProperties clientProperties;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        clientProperties.getClient().forEach(cs -> registry.addInterceptor(new ClientInterceptor(cs.getClientId())).addPathPatterns(cs.getPathPatterns()));

        if (secureRegistry.isEnable()) {
            registry.addInterceptor(new SecureInterceptor())
                    .excludePathPatterns(secureRegistry.getExcludePatterns())
                    .excludePathPatterns(secureRegistry.getDefaultExcludePatterns())
                    .excludePathPatterns(secureProperties.getExcludePatterns());
        }
    }

    @Bean
    public AuthAspect authAspect() {
        return new AuthAspect();
    }

    @Bean
    @ConditionalOnMissingBean(IClientDetailsService.class)
    public IClientDetailsService clientDetailsService() {
        return new ClientDetailsServiceImpl(jdbcTemplate);
    }

}
