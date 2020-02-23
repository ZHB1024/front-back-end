package com.forever.zhb.common.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtil {
    
    public static void main(String[] args) {
        String names = "jsddlsdaifdjsajsdifds23422321231230988798";
        char[] chars = names.toCharArray();
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        Arrays.asList(chars).stream().map(name -> {
            Integer num = charCount.get(name);
            return num;
        }).collect(Collectors.toList());
        for (char name : chars) {
            Integer num = charCount.get(name);
            if (num == null) {
                charCount.put(name, 1);
                continue;
            }
            charCount.put(name, ++num);
        }
        for (Map.Entry<Character, Integer> c : charCount.entrySet()) {
            System.out.println(c.getKey() + ":" + c.getValue());
        }
    }
    
    

}
