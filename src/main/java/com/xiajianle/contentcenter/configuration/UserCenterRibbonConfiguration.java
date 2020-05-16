package com.xiajianle.contentcenter.configuration;

import org.springframework.cloud.client.ConditionalOnDiscoveryHealthIndicatorEnabled;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;
@Configuration
@RibbonClient(name = "user-center", configuration = RibbonConfiguration.class)

    public class UserCenterRibbonConfiguration {
}
