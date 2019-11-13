package com.forever.zhb.server.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forever.zhb.ms.api.MsApi;
import com.forever.zhb.ms.properties.MailProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/server")
public class MsgController {
    
    @Autowired
    private MsApi msFeign;
    
    @Autowired
    private MailProperties mailProperties;
    
    @GetMapping("/sendmail")
    public ResponseEntity<String> sendMsg() {
        String result = mailProperties.getUserName() + "," + mailProperties.getPassword();
        log.info(result);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/sendmsg")
    public ResponseEntity<String> sendMail(){
        String result = msFeign.sendMail("开会通知");
        log.info(result);
        return ResponseEntity.ok(result);
    }

}
