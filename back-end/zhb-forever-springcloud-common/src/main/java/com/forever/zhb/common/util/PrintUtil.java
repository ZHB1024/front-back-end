package com.forever.zhb.common.util;

import java.util.List;
import java.util.Objects;

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
    
    public static <T> void  print(List<T> listsTs) {
        if (Objects.nonNull(listsTs)) {
            listsTs.forEach(o -> System.out.println(o.toString()));
        }
    }

}
