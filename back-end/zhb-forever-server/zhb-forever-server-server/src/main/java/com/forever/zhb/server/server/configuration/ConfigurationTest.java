package com.forever.zhb.server.server.configuration;

import com.forever.zhb.server.server.configuration.beans.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackages="com.forever.zhb.server.server.configuration.beans")
public class ConfigurationTest {

    public ConfigurationTest(){
        log.info("ConfigurationTest启动容器初始化...");
    }

    //@Bean(name = "student")
    public Student getStudent(){
        return new Student();
    }
}
