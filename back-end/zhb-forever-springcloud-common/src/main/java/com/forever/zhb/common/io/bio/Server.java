package com.forever.zhb.common.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    
    private static final int PORT = 8080;
    
    private static AtomicInteger nums = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        System.out.println("server main begin....");
        ServerSocket serverSocket = new ServerSocket(PORT,1);
        while(true) {
            System.out.println("server-socket is listenning.....");
            Socket socket = serverSocket.accept();
            System.out.println("server-socket accept a socket");
            new SocketHandler(socket,nums.incrementAndGet());
        }
    }
    
    public static class SocketHandler implements Runnable{
        
        private Socket socket;
        private int num;
        
        public SocketHandler(Socket socket,int num) {
            this.socket = socket;
            this.num = num;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println(num + "-socket-handler is processing.....");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = reader.readLine();
                System.out.println(num + "-server reading：" + line);
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println(num + "-服务端返回 success " + System.currentTimeMillis());
                
                printStream.close();
                reader.close();
                System.out.println(num + "-socket-handler is done.....");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }

}
