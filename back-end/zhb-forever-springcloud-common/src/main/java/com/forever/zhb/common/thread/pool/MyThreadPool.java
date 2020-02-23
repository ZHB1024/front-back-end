package com.forever.zhb.common.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.forever.zhb.common.thread.factory.MyThreadFactory;
import com.forever.zhb.common.thread.rejectpolicy.MyRejectPolicy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThreadPool {
    
    
    public static ThreadPoolExecutor newThreadPool(int core,int max,BlockingQueue<Runnable> blockingQueue,int timeSecond) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(core,
                max,
                timeSecond,
                TimeUnit.SECONDS,
                blockingQueue,
                new MyThreadFactory(),
                new MyRejectPolicy());
        log.info("myThreadPool create " + pool.toString());
        return pool;
    }

}
