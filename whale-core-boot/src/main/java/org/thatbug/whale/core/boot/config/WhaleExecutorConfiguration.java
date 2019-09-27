package org.thatbug.whale.core.boot.config;

import lombok.AllArgsConstructor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.thatbug.whale.core.boot.props.WhaleAsyncProperties;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步处理
 *
 * @author qzl
 * @date 17:08 2019/9/19
 */
@Configuration
@EnableAsync
@EnableScheduling
@AllArgsConstructor
@EnableConfigurationProperties({
        WhaleAsyncProperties.class
})
public class WhaleExecutorConfiguration extends AsyncConfigurerSupport {

    private final WhaleAsyncProperties whaleAsyncProperties;

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(whaleAsyncProperties.getCorePoolSize());
        executor.setMaxPoolSize(whaleAsyncProperties.getMaxPoolSize());
        executor.setQueueCapacity(whaleAsyncProperties.getQueueCapacity());
        executor.setKeepAliveSeconds(whaleAsyncProperties.getKeepAliveSeconds());
        executor.setThreadNamePrefix("async-executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

}
