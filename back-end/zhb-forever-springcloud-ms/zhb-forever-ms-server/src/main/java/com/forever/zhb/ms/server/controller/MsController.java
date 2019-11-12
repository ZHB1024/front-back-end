package com.forever.zhb.ms.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/msg")
public class MsController {
    
    @GetMapping("/sendmail")
    public String sendMail(String content) {
        return "sendMail:success,content:" + content;
    }
    
    

}
