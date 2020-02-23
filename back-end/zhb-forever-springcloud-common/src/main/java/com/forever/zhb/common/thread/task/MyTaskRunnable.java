package com.forever.zhb.common.thread.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTaskRunnable implements Runnable {

    private String name;
    
    public MyTaskRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " execute task...");
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return "MyTask [name=" + name + "]";
    }

}
