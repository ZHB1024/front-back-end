package com.forever.zhb.common.entity;

import java.util.ArrayList;
import java.util.List;

import com.forever.zhb.common.RandomUtil;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude= {"temp"})
@RequiredArgsConstructor
public class Person {

    private String idcard;
    private String lastName;
    private int age;
    private String temp;
    
    public static List<Person> initPersons(int num){
        List<Person> persons = new ArrayList<>();
        while(num > 0) {
            Person person = new Person();
            person.setIdcard(RandomUtil.getRandomString(5));
            person.setLastName(RandomUtil.randomName(num));
            person.setAge(RandomUtil.randomAge());
            persons.add(person);
            num--;
        }
        return persons;
    }
}
