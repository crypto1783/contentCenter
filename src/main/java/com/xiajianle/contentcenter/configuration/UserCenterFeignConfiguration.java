package com.xiajianle.contentcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Feign的配置类
 */
public class UserCenterFeignConfiguration {
    @Bean
    public Logger.Level level()
    {
        return Logger.Level.FULL;
    }
}
