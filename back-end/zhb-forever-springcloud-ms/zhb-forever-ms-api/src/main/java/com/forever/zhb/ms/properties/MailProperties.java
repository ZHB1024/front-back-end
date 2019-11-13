package com.forever.zhb.ms.properties;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
@ConfigurationProperties(prefix = "zhb.forever.mail",ignoreUnknownFields = false)
public class MailProperties {

    @NotNull private String userName;
    @NotEmpty private String password;
}
