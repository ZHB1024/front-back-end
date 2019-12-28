package com.forever.zhb.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintUtil {
    
    static {
        log.info("......................");
    }
    
    public static <T> void print(T object) {
        System.out.print(object);
    }
    public static <T> void print(T[] object) {
        for (T t : object) {
            System.out.print(t + ", ");
        }
        
    }
    
    public static <T> void println(T[] object) {
        for (T t : object) {
            System.out.println(t + ", ");
        }
    }

}
