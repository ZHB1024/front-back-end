package com.forever.zhb.common.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.forever.zhb.common.io.bio.task.ClientRunnable;

public class Client {

    private static AtomicInteger nums = new AtomicInteger(0);
    
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        pool.execute(new ClientRunnable("client1-", nums));
        //pool.execute(new ClientRunnable("client2-", nums));
        pool.shutdown();
    }

}
