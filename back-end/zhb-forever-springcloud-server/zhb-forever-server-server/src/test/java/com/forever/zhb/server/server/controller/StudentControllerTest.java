package com.forever.zhb.server.server.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.forever.zhb.server.server.BaseTest;


public class StudentControllerTest extends BaseTest{

    
    @Test
    public void queryStudentByNameTest() throws Exception {
        System.out.println("---------");
        mockMvc.perform(MockMvcRequestBuilders.get("/student/querystudentbyname")
                .param("name","admin1")
                .header("from", "gateway")
                // 请求type : json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 期望的返回结果集合有2个元素 ， $: 返回结果
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0));
    }

}
