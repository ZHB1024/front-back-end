package com.forever.zhb.server.server.configuration.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {
    private String name;
    private String sno;
}
