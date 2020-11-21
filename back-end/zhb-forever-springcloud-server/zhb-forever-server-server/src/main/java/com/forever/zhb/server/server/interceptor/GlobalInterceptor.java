package com.forever.zhb.server.server.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GlobalInterceptor implements HandlerInterceptor {

    /**
     * 拦截器配置
     *  验证请求是否包含gateway授予的令牌，保证所有请求经过gateway
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        log.info("begin globalInterceptor");
        String secretKey = request.getHeader("from");
        if(!StringUtils.isNotBlank(secretKey)|| !secretKey.equals("gateway")){
            log.error("sercreKey 【from】 is null" );
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("globalInterceptor parame [from] is null");
            return false;
        }
        return true;
    }
}
