package com.forever.zhb.common.javase8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Chapter2 {
    
    public static void main(String[] args) throws IOException {
        /*String fileName = "C:\\Users\\ZHB1024\\Desktop\\测试文件\\BCCS_001_AACDAC_0039_20200206.utf";
        File file = new File(fileName);
        if (file.exists()) {
            List<String> result = readLastNLine(file);
            result.forEach(k -> System.out.println(k));
        }*/
        /*String param = "0x030a";
        String[] formats = param.split("0x");
        
        System.out.println(formats[1] + ":" + Integer.parseInt(formats[1], 16));*/
        
        String fileName = "/fileroot/acca/dcbs/zhanghuib.utf.temp";
        System.out.println(fileName.endsWith(".temp"));
        fileName = fileName.substring(0, fileName.indexOf(".temp"));
        System.out.println(fileName);
        
    }
    
    /**
     * 读取文件最后N行
     * 输出的时候请逆序输出
     * @param file
     * @param numRead
     * @return List<String>
     */
   public static List<String> readLastNLine(File file) {
       List<String> result = new ArrayList<String>();
       if (!file.exists() || file.isDirectory() || !file.canRead()) {
           return null;
       }
       RandomAccessFile fileRead = null;
       try {
           fileRead = new RandomAccessFile(file, "r"); //用读模式
           long length = fileRead.length();//获得文件长度
           if (length == 0L) {//文件内容为空
               return result;
           } else {
               // 开始位置
               long pos = length - 1;
               fileRead.seek(pos-1); // 开始读取
               result.add(fileRead.readLine());
               /*while (pos > 0) {
                   pos--;
                   fileRead.seek(pos); // 开始读取
                   if (fileRead.readByte() == '\n') {//有换行符，则读取
                       String line = new String(fileRead.readLine().getBytes("ISO-8859-1"),"UTF-8");
                       result.add(line);
                   }
                   if (pos == 0) {
                       break;
                   }
               }

               if (pos == 0) {
                   fileRead.seek(0);
                   result.add(new String(fileRead.readLine().getBytes("ISO-8859-1"),"UTF-8"));
               }*/
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (fileRead != null) {
               try {
                   // 关闭资源
                   fileRead.close();
               } catch (Exception e) {
               }
           }
       }

       return result;
   }
   
   public static List<String> readLastNLine1(File file) {
       List<String> result = new ArrayList<String>();
       if (!file.exists() || file.isDirectory() || !file.canRead()) {
           return null;
       }
       RandomAccessFile fileRead = null;
       try {
           fileRead = new RandomAccessFile(file, "r"); //用读模式
           long length = fileRead.length();//获得文件长度
           if (length == 0L) {//文件内容为空
               return result;
           } else {
               // 开始位置
               long pos = length - 1;
               while (pos > 0) {
                   pos--;
                   fileRead.seek(pos); // 开始读取
                   if (fileRead.readByte() == '\n') {//有换行符，则读取
                       String line = new String(fileRead.readLine().getBytes("ISO-8859-1"),"UTF-8");
                       result.add(fileRead.readLine());
                   }
                   if (pos == 0) {
                       break;
                   }
               }

               if (pos == 0) {
                   fileRead.seek(0);
                   result.add(new String(fileRead.readLine().getBytes("ISO-8859-1"),"UTF-8"));
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (fileRead != null) {
               try {
                   // 关闭资源
                   fileRead.close();
               } catch (Exception e) {
               }
           }
       }

       return result;
   }


}
