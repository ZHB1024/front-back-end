package com.forever.zhb.common.io.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {

    public static void main(String[] args) throws IOException {
        readLine();
        

    }
    
    
    public static void readChar() throws IOException {
        System.out.println("请输入一个字符");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c ;
        c = (char) bufferedReader.read();
        System.out.println(c);
    }
    
    public static void readChars() throws IOException {
        System.out.println("请输入一个字符，按q键结束");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c ;
        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        } while (c!='q');
        
    }
    
    public static void readLine() throws IOException {
        System.out.println("请输入一行字符");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String value = bufferedReader.readLine();
        System.out.println(value);
    }

}
