package com.forever.zhb.ms.api;

import org.springframework.stereotype.Component;

@Component
public class MsFeignClientFallback implements MsApi {
    @Override
    public String sendMail(String content) {
        return "ms server is down,this is 熔断、降级";
    }

}
