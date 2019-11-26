package com.zhb.study.aop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student implements BaseInterface{
    
    public static String sno = "2011";
    
    static {
        System.out.println("this is Student static code ");
    }

    private  String name;
    private  int age;
    
    @Override
    public void doing() {
        System.out.println("student is studing...");
    }
}
