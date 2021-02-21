package com.forever.zhb.common.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int headLength = 8;
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.out.println("server start************************");
        ServerSocket server = new ServerSocket(9551);
        while(true) {
            Socket socket = server.accept();
            System.out.println("server accept**********");
            InputStream inputStream = socket.getInputStream();
            byte[] headBytes = new byte[headLength];
            inputStream.read(headBytes);
            
            int msgLegnth = Integer.parseInt(new String(headBytes, "UTF-8"));
            System.out.println("server: msgLength-" + msgLegnth);
            byte[] msgByte = new byte[msgLegnth];
            inputStream.read(msgByte);
            String rest = byte2String(msgByte);
            System.out.println("server:msg-" + rest);
            inputStream.close();
            System.out.println("server accept end**********");
            
            MsgObj msgObj = JaxbUtil.converyToJavaBean(rest, MsgObj.class);
            System.out.println(msgObj.toString());
        }

    }
    
    private static int byte2Int(byte[] b) {
        return b[3]&0xFF | (b[2]&0xFF) << 8 | (b[1]&0xFF) << 16 | (b[0]&0xFF) << 24 ;
    }
    
    private static String byte2String(byte[] bytes) {
        return new String(bytes);
    }

}
