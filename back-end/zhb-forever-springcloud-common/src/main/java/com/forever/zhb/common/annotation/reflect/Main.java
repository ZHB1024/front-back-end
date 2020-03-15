package com.forever.zhb.common.annotation.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.forever.zhb.common.annotation.Info;
import com.forever.zhb.common.annotation.model.Student;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class clazz = Student.class;
        if (clazz.isAnnotationPresent(Info.class)) {
            Info info = (Info) clazz.getAnnotation(Info.class);
            if (info.isDelete()) {
                Constructor<Student> constructor = clazz.getConstructor(String.class,int.class);
                Student student = constructor.newInstance("123",2);
                System.out.println(student.toString());
            }
        }
    }

}
