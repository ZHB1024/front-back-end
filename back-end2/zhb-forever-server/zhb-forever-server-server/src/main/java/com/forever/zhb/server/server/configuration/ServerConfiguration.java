package com.forever.zhb.server.server.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import com.forever.zhb.ms.api.MsApi;

import lombok.extern.slf4j.Slf4j;

@Configuration
//@EnableFeignClients(basePackages = "com.forever.zhb.ms.api")
@EnableFeignClients(basePackageClasses =  {MsApi.class})
@Slf4j
public class ServerConfiguration {
    
    public ServerConfiguration() {
        log.info("init server configuration....");
    }

}
