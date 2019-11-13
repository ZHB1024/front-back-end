package com.forever.zhb.server.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forever.zhb.server.dao.dao.StudentDao;
import com.forever.zhb.server.model.entity.StudentEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl {
    
    @Autowired
    private StudentDao studentDao;
    
    public StudentEntity getStudentEntityBySno(String sno) {
        StudentEntity studentEntity = studentDao.getStudentEntityBySno(sno);
        log.info(studentEntity.getName() + "," + studentEntity.getSno());
        return studentEntity;
    }

}
