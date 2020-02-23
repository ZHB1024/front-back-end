package com.forever.zhb.common.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.forever.zhb.common.thread.pool.MyThreadPool;
import com.forever.zhb.common.thread.task.MyTaskRunnable;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = MyThreadPool.newThreadPool(2, 4, new ArrayBlockingQueue<>(2), 5);
        for (int i = 0; i < 10; i++) {
            pool.execute(new MyTaskRunnable("mytask-"+i));
        }
        pool.shutdown();
    }

}
