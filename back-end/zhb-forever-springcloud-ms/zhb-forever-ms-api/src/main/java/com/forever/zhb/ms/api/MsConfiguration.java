package com.forever.zhb.ms.api;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableFeignClients(basePackageClasses = { MsApi.class})
public class MsConfiguration {
    
    public MsConfiguration() {
        log.info("init MsConfiguration bean...");
    }

}
