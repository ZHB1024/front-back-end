# springcloud config server
配置文件加密解密
1、下载JCE
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

2、解压后，将 local_policy.jar 和 US_export_policy.jar 
 放入%JDK_HOME%/jre/lib/security下
 
 3、config server 配置文件中加入
encrypt:
  key: ZHB1024

4、编写加密接口
