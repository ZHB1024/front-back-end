package com.forever.zhb.common.annotation.model;

import com.forever.zhb.common.annotation.Info;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Info(isDelete = true)
public class Student {
    
    private final String name;
    private final int age;
    
    
}
