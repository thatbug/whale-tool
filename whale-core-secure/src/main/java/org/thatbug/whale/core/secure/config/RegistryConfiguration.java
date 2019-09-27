package org.thatbug.whale.core.secure.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.thatbug.whale.core.secure.registry.SecureRegistry;

/**
 * 注册配置
 *
 * @author qzl
 * @date 15:14 2019/9/17
 */
@Order
@Configuration
@AutoConfigureBefore(SecureConfiguration.class)
public class RegistryConfiguration {

    @Bean
    @ConditionalOnMissingBean(SecureRegistry.class)
    public SecureRegistry secureRegistry() {
        return new SecureRegistry();
    }

}
