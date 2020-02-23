package com.forever.zhb.common.thread.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger nums;
    
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,"MyThread-"+nums);
        return thread;
    }

}
