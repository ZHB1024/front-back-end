package com.forever.zhb.config;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EncryptDecrptUtil {
    
    private static final String ENCRYPT = "http://localhost:8010/encrypt";
    private static final String DECRPT = "http://localhost:8010/decrypt";
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
        //加密
        encrypt();
        //解密
        //decrypt();
    }
    
    private static void encrypt() throws ClientProtocolException, IOException {
        /*
         * CloseableHttpClient client = HttpClients.createDefault(); // 发送post请求
         * HttpPost post = new HttpPost(ENCRYPT); // 设置请求的参数，对20180323进行加密，编码格式为UTF-8
         * HttpEntity entity = new StringEntity("ZHBzhb1024", Consts.UTF_8);
         * post.setEntity(entity);
         * 
         * HttpResponse response = client.execute(post);
         * System.out.println(EntityUtils.toString(response.getEntity()));
         */
        
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> msg = template.postForEntity(ENCRYPT, "123456", String.class);
        System.out.println(msg.getBody());
    }
    
    private static void decrypt() throws ParseException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送post请求
        HttpPost post = new HttpPost(DECRPT);
        // 设置请求的参数，对密码进行解密，编码格式为UTF-8
        HttpEntity entity = new StringEntity("", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}
