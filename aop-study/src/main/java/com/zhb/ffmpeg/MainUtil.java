package com.zhb.ffmpeg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class MainUtil {

    public static final String PATH = "E:\\迅雷下载\\yellow";
    public static final String PATH_TXT = "E:\\迅雷下载\\yellow\\yellow.txt";
    public static final String PATH_TXT_FILE = "E:\\迅雷下载\\yellow\\yellow_file.txt";
    public static final String PATH_MP4 = "E:\\迅雷下载\\yellow\\yellow.mp4";
    
    public static final String COMMAND = "ffmpeg -protocol_whitelist “file,http,https,tcp,tls” -f concat -safe 0 -i E:\\迅雷下载\\yellow\\yellow_file.txt -c copy E:\\迅雷下载\\yellow\\yellow.mp4";
    
    public static final String BLANK = ",";
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        /*byte[] bytes = FileUtil.readFilePathAsBytes(PATH_TXT);
        String content = new String(bytes, "utf-8");
        System.out.println(content);
        String[] files = content.split(BLANK);
        File yellow_file = new File(PATH_TXT_FILE);
        if (yellow_file.exists()) {
            yellow_file.delete();
        }
        yellow_file.createNewFile();
        FileWriter fileWriter = new FileWriter(yellow_file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder sb = new StringBuilder();
        for (String string : files) {
            sb.setLength(0);
            sb.append("file 'https://3.ddyunbo.com/20201002/5W7pjUl8/600kb/hls/");
            sb.append(string);
            sb.append("'");
            bufferedWriter.write(sb.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();*/
        String webroot = "D:\\soft\\ffmpeg\\install\\bin";
        File ffmpegPath = new File(webroot);
        File file_url = new File(PATH_TXT_FILE);
        File file_mp4 = new File(PATH_MP4);
        long start=System.currentTimeMillis();
        System.out.println(ffmpegPath.getAbsolutePath());
        
        StringBuilder command = new StringBuilder();
        command.append(ffmpegPath.getAbsolutePath());
        command.append("/ffmpeg.exe -protocol_whitelist \"file,http,https,tcp,tls\" -f concat -safe 0 -i ");
        command.append(file_url.getAbsolutePath());
        command.append(" -c copy ");
        command.append(file_mp4.getAbsolutePath());
        
        System.out.println(command.toString());
        Process p = Runtime.getRuntime().exec(command.toString());
        p.getOutputStream().close();
        p.getInputStream().close();
        p.getErrorStream().close();
        p.waitFor();

        long end=System.currentTimeMillis();

        System.out.println("success, costs:"+(end-start)+"ms");

    }

}
