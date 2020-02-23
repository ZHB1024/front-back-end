package com.forever.zhb.common.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.forever.zhb.common.entity.Person;

public class LambdaUtil {

    private static List<String> lists = Arrays.asList("zhanghuibin","wanglingxu","zhanghuibin","wangzenghui");
    
    public static void main(String[] args) {
        //distinct();
        //compare();
        personReduce();
    }
    
    private static void distinct() {
        List<String> vlaue1 = lists.stream().distinct().collect(Collectors.toList());
        PrintUtil.print(vlaue1);
    }
    
    private static void compare() {
        List<String> vlaue = lists.stream().sorted((v1,v2) -> v1.compareTo(v2)).collect(Collectors.toList());
        PrintUtil.print(vlaue);
    }
    
    private static void personCompare() {
        List<Person> persons = Person.initPersons(10);
        Collections.sort(persons, Comparator.comparing(Person::getIdcard).thenComparing(Person::getAge));
        PrintUtil.print(persons);
    }
    
    private static void personReduce() {
        List<Person> persons = Person.initPersons(10);
        String json =
                persons.stream()
                  .map(Person::toString)
                  .reduce("[", (l, r) -> l + (l.equals("[") ? "" : ",") + r)
                  + "]";
        PrintUtil.print(json);
    }
}
