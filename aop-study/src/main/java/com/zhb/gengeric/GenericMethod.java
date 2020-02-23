package com.zhb.gengeric;

public class GenericMethod {
    
    public static <T> void printAll(T item) {
        System.out.println(item);
    }
    public static <T extends Number> void print(T item) {
        System.out.println(item);
    }
}
