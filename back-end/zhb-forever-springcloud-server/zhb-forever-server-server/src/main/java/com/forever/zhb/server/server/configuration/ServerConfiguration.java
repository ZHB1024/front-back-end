package com.forever.zhb.server.server.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.forever.zhb.ms.api.MsApi;
import com.forever.zhb.ms.properties.MailProperties;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableFeignClients(basePackages = "com.forever.zhb.ms.api")
@EnableFeignClients(basePackageClasses =  {MsApi.class})
@EnableConfigurationProperties({MailProperties.class})
@Slf4j
public class ServerConfiguration {
    
    public ServerConfiguration() {
        log.info("init server configuration....");
    }
    
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket createRestApi() {
            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .groupName("zhb-forever")
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.ant("/**"))
                    .build();
            return docket;
        }
        
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("zhb-forever-springcloud")
                    .contact(new Contact("zhb-forever", 
                            "https://github.com/ZHB1024/", 
                            "zhb20111503@126.com"))
                    .build();
        }
    }

}
