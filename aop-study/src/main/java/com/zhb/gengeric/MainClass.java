package com.zhb.gengeric;

public class MainClass {

    public static void main(String[] args) {
        String name = "zhanghuibin";
        int age = 20;
        long num = 10;
        GenericMethod.printAll(name);
        GenericMethod.print(age);
        GenericMethod.print(num);
    }

}