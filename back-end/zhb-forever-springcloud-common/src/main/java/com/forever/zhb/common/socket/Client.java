package com.forever.zhb.common.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    private static int headLength = 8;

    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO Auto-generated method stub
        System.out.println("client start--------------------------");
        Socket client = new Socket("127.0.0.1",9551);
        OutputStream outputStream = client.getOutputStream();
        String msg = msg();
        byte[] b = msg.getBytes("UTF-8");
        outputStream.write(int2Bytes8(b.length));
        outputStream.write(b);
        outputStream.flush();
        outputStream.close();
        
        /*InputStream inputStream = client.getInputStream();
        inputStream.read();
        inputStream.close();*/
        
        client.close();
        System.out.println("client close--------------------------");

    }
    
    private static String msg() {
        MsgObj msg = new MsgObj();
        msg.setName("zhanghuibin");
        msg.setAge("31");
        msg.setCode("java");
        String msString = JaxbUtil.convertToXml(msg);
        System.out.println(msString);
        return msString;
    }
    
    
    public static byte[] int2Bytes8(int num) {
        System.out.println("client msg length:" + num);
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = 8 - sb.length();
        for (int i = 0; i < length; i++) {
            sb.insert(0, '0');
        }
        return sb.toString().getBytes();
    }

}
