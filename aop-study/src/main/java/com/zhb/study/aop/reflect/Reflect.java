package com.zhb.study.aop.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.zhb.study.aop.entity.Student;

public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<Student> stuClass = Student.class;
        //Class<Student> stuClass = (Class<Student>)Class.forName("com.zhb.study.aop.entity.Student");
        Constructor<?>[] constants = stuClass.getConstructors();
        for (Constructor<?> constructor : constants) {
            Student student = (Student) constructor.newInstance();
            System.out.println(student);
        }
        
        
        //System.out.println(student.newInstance().sno);
    }

}
