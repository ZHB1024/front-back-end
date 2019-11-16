package com.forever.zhb.server.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forever.zhb.server.dao.dao.StudentDao;
import com.forever.zhb.server.dao.repository.StudentRepository;
import com.forever.zhb.server.mapper.StudentMapper;
import com.forever.zhb.server.model.entity.StudentData;
import com.forever.zhb.server.model.entity.StudentEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl {
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private StudentMapper studentMapper;
    
    public StudentEntity getStudentEntityBySno(String sno) {
        StudentEntity studentEntity = studentDao.getStudentEntityBySno(sno);
        log.info(studentEntity.getName() + "," + studentEntity.getSno());
        return studentEntity;
    }

    public List<StudentEntity> findBySno(String sno) {
        return studentRepository.findBySno(sno);
    }
    
    public List<StudentEntity> findByName(String name){
        return studentRepository.findByName(name);
    }
    
    public Optional<StudentEntity> findBySnoAndName(String sno,String name){
        return studentRepository.findBySnoAndName(sno,name);
    }
    
    public List<String> findSnoBy(){
        return studentRepository.findSnoBy();
    }
    
    public List<StudentData> queryStudentByName(String name){
        return studentMapper.queryStudentByName(name);
    }
}
