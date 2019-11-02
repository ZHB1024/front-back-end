package com.forever.zhb.server.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*@FeignClient(url="http://localhost:8012",name = "MsFeign")*/
public interface MsFeign {

    @GetMapping("/msg/sendmail")
    String sendMail(@RequestParam("content") String content);
}
