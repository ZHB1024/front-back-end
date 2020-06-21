package com.forever.zhb.common.javase8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Example {
    
    public static void main(String[] args) {
        listIterator();
    }
    
    private static void myThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java7");
            }
        });
        
        new Thread(()->System.out.println("java8"));
    }
    
    private static void listIterator() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        
        //.forEach(value->System.out.println(value));
        //features.forEach(System.out::println);
        
        //filter(features, value->value.contains("API"));
        
        Predicate<String> contain = value->value.contains("API");
        List<String> temps = features.stream().filter(contain).collect(Collectors.toList());
        //System.out.println(temps.toString());
        
        //features.stream().map(value->value.concat("123")).forEach(System.out::println);
        
        //features.stream().reduce(value->valu).get();
        
        System.out.println(features.toString());
        
    }
    
    private static void filter(List<String> values,Predicate<String> condition) {
        for (String string : values) {
            if (condition.test(string)) {
                System.out.println(string);
            }
        }
    }

}
