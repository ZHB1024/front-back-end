package com.forever.zhb.ms.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.forever"})
public class MsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MsApplication.class, args);
    }

}
