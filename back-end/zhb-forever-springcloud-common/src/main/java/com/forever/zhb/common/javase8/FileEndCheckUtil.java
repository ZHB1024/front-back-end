package com.forever.zhb.common.javase8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: nio->FileEndCheckUtil
 * @description:
 * @author: Gang Ma
 * @email: magang2@citicbank.com
 * @create: 2020-02-06 19:46
 **/
public class FileEndCheckUtil {

    public static void main(String[] args) {
        //String filePath = "C:\\Users\\ZHB1024\\Desktop\\PSMG_001_FLAGUAB_103256_20200114.utf";
        String filePath = "C:\\Users\\ZHB1024\\Desktop\\测试文件\\EMSS_001_CUSTOREQ_164706_20200207.utf";
        FileEndCheckUtil.checkFileEnd(filePath);
    }

    /**
     * 从文件末尾开始读取文件
     * @param filePath    file path
     */
    public static boolean checkFileEnd(String filePath) {
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(filePath, "r");
            long fileLength = rf.length();
            long start = rf.getFilePointer();       // 返回此文件中的当前偏移量
            long readIndex = start + fileLength - 1; // 文件末尾位置

            System.out.println("fileLength is " + fileLength);
            if (fileLength < 2) {
                System.out.println("Empty file and cannot check, fileLength is " + fileLength);
            }

            //Reads a byte of data from this file
            rf.seek(readIndex);     // 设置文件读取偏移量，从文件末尾开始
            int end_1 = rf.read();  // 保存文件倒数第一个字节
            readIndex--;
            rf.seek(readIndex);     // 文件正文中的倒数第二个字节
            int end_2 = rf.read();  // 保存文件倒数第二个字节
            System.out.println("end_1 and end_2 is " + end_1 + ", " + end_2);
            System.out.println("end_1 and end_2 is " + Character.forDigit(end_1, 16) + ", " + Character.forDigit(end_2, 16));

            // int 10 十六进制是 0x0a, int 3 十六进制是 0x03
            if (end_1 == 10 && end_2 == 3) {
                System.out.println("The file end is 0x030a");
                return true;
            } else {
                System.out.println(filePath + " file end is not 0x030a, " + "the last is " + end_1 + ", hte second last is " + end_2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rf != null)
                    rf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
