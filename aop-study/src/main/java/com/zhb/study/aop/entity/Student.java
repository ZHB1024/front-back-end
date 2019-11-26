package com.zhb.study.aop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {

    private final String name;
    private final int age;
}
