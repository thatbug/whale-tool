package org.thatbug.whale.core.launch.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.thatbug.whale.core.launch.props.WhaleProperties;

/**
 * 配置类
 *
 * @author qzl
 * @date 18:31 2019/9/16
 */
@Configuration
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties({WhaleProperties.class})
public class WhaleLaunchConfiguration {

}
