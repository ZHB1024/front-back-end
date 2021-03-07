package com.forever.zhb.server.server.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "file接口")
@RestController
@RequestMapping("/file")
public class FileController {
    
    @ApiOperation("upload")
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("fileName") String fileName,@RequestParam("files") List<MultipartFile> files){
        log.info("upload file");
        log.info(fileName);
        if (null != files) {
            log.info(files.size()+"");
        }
        for (MultipartFile multipartFile : files) {
            log.info(multipartFile.getOriginalFilename());
        }
        return ResponseEntity.ok("success");
    }

}
