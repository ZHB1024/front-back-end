package com.forever.zhb.server.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/configserver")
@RefreshScope
public class ConfigServerController {
    
    @Value("${spring.application.name.first}")
    private String springApplicationName;
    
    @RequestMapping("/springappname")
    public ResponseEntity<String> getSpringApplicationName(){
        log.info(springApplicationName);
        return ResponseEntity.ok(this.springApplicationName);
    }

}
