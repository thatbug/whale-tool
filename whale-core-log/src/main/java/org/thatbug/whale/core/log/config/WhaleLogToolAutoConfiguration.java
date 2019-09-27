package org.thatbug.whale.core.log.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thatbug.whale.core.launch.props.WhaleProperties;
import org.thatbug.whale.core.launch.server.ServerInfo;
import org.thatbug.whale.core.log.aspect.ApiLogAspect;
import org.thatbug.whale.core.log.event.ApiLogListener;
import org.thatbug.whale.core.log.event.ErrorLogListener;
import org.thatbug.whale.core.log.event.UsualLogListener;
import org.thatbug.whale.core.log.feign.ILogClient;
import org.thatbug.whale.core.log.logger.WhaleLogger;

/**
 * 日志工具自动配置
 *
 * @author qzl
 * @date 16:15 2019/9/19
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class WhaleLogToolAutoConfiguration {

    private final ILogClient logService;
    private final ServerInfo serverInfo;
    private final WhaleProperties whaleProperties;

    @Bean
    public ApiLogAspect apiLogAspect() {
        return new ApiLogAspect();
    }

    @Bean
    public WhaleLogger bladeLogger() {
        return new WhaleLogger();
    }

    @Bean
    public ApiLogListener apiLogListener() {
        return new ApiLogListener(logService, serverInfo, whaleProperties);
    }

    @Bean
    public ErrorLogListener errorEventListener() {
        return new ErrorLogListener(logService, serverInfo, whaleProperties);
    }

    @Bean
    public UsualLogListener bladeEventListener() {
        return new UsualLogListener(logService, serverInfo, whaleProperties);
    }

}
