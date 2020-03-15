package com.forever.zhb.ms.api;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.forever.zhb.ms.properties.MailProperties;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableFeignClients(basePackageClasses = { MsApi.class})
@EnableConfigurationProperties({MailProperties.class})
@ComponentScan(basePackageClasses = { MsFeignClientFallback.class})
public class MsConfiguration implements RequestInterceptor {
    
    public MsConfiguration() {
        log.info("init MsConfiguration bean...");
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("from", "gateway");
    }

}
