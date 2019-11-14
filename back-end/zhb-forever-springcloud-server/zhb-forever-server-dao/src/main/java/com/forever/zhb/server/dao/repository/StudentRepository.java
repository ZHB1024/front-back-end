package com.forever.zhb.server.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.forever.zhb.server.model.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    
    List<StudentEntity> findBySno(String sno);
    
    List<StudentEntity> findByName(String name);
    
    Optional<StudentEntity> findBySnoAndName(String sno, String name);
    
    @Query("select sno from StudentEntity where sno is not null")
    List<String> findSnoBy();

}
