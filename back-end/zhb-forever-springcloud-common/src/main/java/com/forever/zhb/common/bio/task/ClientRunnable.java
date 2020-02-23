package com.forever.zhb.common.bio.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import com.forever.zhb.common.util.CommonUtil;

public class ClientRunnable implements Runnable {
    
    private String name;
    private AtomicInteger nums = null;
    
    
    public ClientRunnable(String name,AtomicInteger nums) {
        this.name = name;
        this.nums = nums;
    }

    @Override
    public void run() {
        while (true) {
            Socket socket;
            try {
                socket = new Socket(CommonUtil.IP,CommonUtil.PORT);
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println(name + nums.incrementAndGet());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String vaule = bufferedReader.readLine();
                System.out.println(name + "receive: " + vaule);
                printStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
    }

}
