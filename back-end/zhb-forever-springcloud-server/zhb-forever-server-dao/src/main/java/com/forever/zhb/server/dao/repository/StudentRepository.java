package com.forever.zhb.server.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forever.zhb.server.model.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    
    StudentEntity findBySno(String sno);
    
    Optional<StudentEntity> findByName(String name);

}
