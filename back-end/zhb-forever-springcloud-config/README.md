# springcloud config server 8010
配置文件加密解密
1、下载JCE
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

2、解压后，将 local_policy.jar 和 US_export_policy.jar 
 放入%JDK_HOME%/jre/lib/security下
 
 3、config server 配置文件中加入
encrypt:
  key: ZHB1024

4、加密
curl http://localhost:8010/encrypt -d 123456

5、解密
curl localhost:8010/decrypt -d 847e30e5fc95fd2a3f1d8d3e1db55170d96d711fb18d1996f1c58dad54b10d36


curl安装
下载curl
https://curl.haxx.se/windows/
添加环境变量
CURL_HOME
path中添加 CURL_HOME\bin
