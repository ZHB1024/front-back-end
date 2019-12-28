package com.forever.zhb.common;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LambdaUtil {

private static List<String> lists = Arrays.asList("zhanghuibin","wanglingxu","zhanghuibin","wangzenghui");
    
    private static <T> void  print(List<T> listsTs) {
        if (Objects.nonNull(listsTs)) {
            listsTs.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        //distinct();
        compare();
    }
    
    private static void distinct() {
        List<String> vlaue1 = lists.stream().distinct().collect(Collectors.toList());
        print(vlaue1);
    }
    
    private static void compare() {
        List<String> vlaue = lists.stream().sorted((v1,v2) -> v1.compareTo(v2)).collect(Collectors.toList());
        print(vlaue);
    }
}
