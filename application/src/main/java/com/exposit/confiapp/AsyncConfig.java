package com.exposit.confiapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Class to configure Async in spring boot.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@EnableAsync
public class AsyncConfig {
    /**
     * Configures ThreadPoolTaskExecutor.
     *
     * @return The value executor.
     * @author Yauheni Markevich
     */
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("useThread-");
        executor.initialize();
        return executor;

    }
}
