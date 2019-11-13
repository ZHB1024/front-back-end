package com.forever.zhb.server.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forever.zhb.server.model.entity.StudentEntity;
import com.forever.zhb.server.server.service.StudentServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "student接口")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;
    
    @ApiOperation("查询student by sno")
    @ApiImplicitParam(name = "sno", value = "学号",  paramType="query", required = true)
    @GetMapping("/querybysno")
    public ResponseEntity<StudentEntity> queryStudentBySno(@RequestParam(name="sno",required = true)String sno){
        log.info(sno);
        StudentEntity studentEntity = studentServiceImpl.getStudentEntityBySno(sno);
        return ResponseEntity.ok(studentEntity);
    }
}
