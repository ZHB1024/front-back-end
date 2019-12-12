package com.forever.zhb.common;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceLoaderUtil {
    
    private static final String APPLICATION_RESOURCE_LOCATION = "application.yaml";
    
    public static void main(String[] args) throws IOException {
        
        loadResources(APPLICATION_RESOURCE_LOCATION);
    }
    
    private static void loadResources(String resourcePath) throws IOException {
        if (Objects.nonNull(resourcePath)) {
            Enumeration<URL> urls = ClassLoader.getSystemResources(resourcePath);
            if (Objects.nonNull(urls)) {
                while(urls.hasMoreElements()) {
                    URL url = urls.nextElement();
                    UrlResource resource = new UrlResource(url);
                    Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                    for(Map.Entry<?, ?> entry : properties.entrySet()) {
                        String name = (String)entry.getKey();
                        String value = (String)entry.getValue();
                        log.info(name + ":" + value);
                    }
                }
            }
        }
    }

}
