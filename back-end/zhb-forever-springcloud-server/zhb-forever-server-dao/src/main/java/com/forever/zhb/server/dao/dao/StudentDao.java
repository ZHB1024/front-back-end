package com.forever.zhb.server.dao.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.forever.zhb.server.model.entity.StudentEntity;

@Component
public class StudentDao {
    
    @Cacheable("student_find_by_sno")
    public StudentEntity getStudentEntityBySno(String sno) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("hello world");
        studentEntity.setSno("2011");
        return studentEntity;
    }

}
