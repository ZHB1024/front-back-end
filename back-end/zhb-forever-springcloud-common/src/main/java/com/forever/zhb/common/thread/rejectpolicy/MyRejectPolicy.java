package com.forever.zhb.common.thread.rejectpolicy;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRejectPolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        writeLog(r, executor);
    }
    
    private void writeLog(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " rejected");
        //log.error(r.toString() + " rejected");
    }

}
