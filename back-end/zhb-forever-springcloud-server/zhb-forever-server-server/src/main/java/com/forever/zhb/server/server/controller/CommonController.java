package com.forever.zhb.server.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "公共接口")
@RestController
@RequestMapping("/common")
public class CommonController {
    
    @ApiOperation("测试的接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
        @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    })
    @GetMapping("/test")
    public ResponseEntity<String> test(String userName, @RequestParam(required = true) String address) {
        log.info("userName: " + userName + ", address: " + address);
        return ResponseEntity.ok("userName: " + userName + ", address: " + address);
    }
    
    @GetMapping("/test2")
    public ResponseEntity<String> test2(String userName, @RequestParam(required = true) String address) {
        log.info("userName: " + userName + ", address: " + address);
        return ResponseEntity.ok("userName: " + userName + ", address: " + address);
    }

}
