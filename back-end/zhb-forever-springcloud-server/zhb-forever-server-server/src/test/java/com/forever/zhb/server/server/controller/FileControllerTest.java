package com.forever.zhb.server.server.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.forever.zhb.server.server.BaseTest;

public class FileControllerTest extends BaseTest {
    
    @Test
    public void uploadTest() throws Exception {
        System.out.println("---------");
        String result =  mockMvc.perform(
                MockMvcRequestBuilders
                    .multipart("/file/upload")
                    .file(
                        new MockMultipartFile("files", "test.yaml", ",multipart/form-data", "hello upload".getBytes("UTF-8"))
                    )
                    .file(
                            new MockMultipartFile("files", "test1.yaml", ",multipart/form-data", "hello upload23232323".getBytes("UTF-8"))
                            )
                    .param("fileName", "test.yaml")
                    .header("from", "gateway")
            ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse().getContentAsString();
        System.out.println(result);
        
        
        
        
        /*MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,"----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());  
        multipartEntity.addPart("files",new FileBody(new File("E:\\123.txt"),"txt"));    
            
        HttpGet request = new HttpGet("http://127.0.0.1:8080//file/upload");     
        request.setEntity(multipartEntity);  
        request.addHeader("Content-Type","multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");  
          
        DefaultHttpClient httpClient = new DefaultHttpClient();  
        HttpResponse response =httpClient.execute(request);  
          
        InputStream is = response.getEntity().getContent();  
        BufferedReader in = new BufferedReader(new InputStreamReader(is));  
        StringBuffer buffer = new StringBuffer();  
        String line = "";  
        while ((line = in.readLine()) != null) {  
            buffer.append(line);  
        }  
          
        System.out.println("发送消息收到的返回："+buffer.toString());*/
    }

}
