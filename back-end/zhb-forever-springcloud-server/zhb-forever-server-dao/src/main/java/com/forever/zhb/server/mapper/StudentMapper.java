package com.forever.zhb.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.forever.zhb.server.model.entity.StudentData;

@Mapper
public interface StudentMapper {
    
    List<StudentData> queryStudentByName(@Param("name")String name);

}
