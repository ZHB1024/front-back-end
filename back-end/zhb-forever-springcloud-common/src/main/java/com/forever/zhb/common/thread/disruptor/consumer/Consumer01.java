package com.forever.zhb.common.thread.disruptor.consumer;

import com.forever.zhb.common.thread.disruptor.event.LongEvent;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class Consumer01 implements EventHandler<LongEvent> , WorkHandler<LongEvent>{

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(Thread.currentThread().getName() + ",onEvent-a," + event.getNumber());
    }

    @Override
    public void onEvent(LongEvent event) throws Exception {
        System.out.println(Thread.currentThread().getName() + ",onEvent-b," + event.getNumber());
    }

}
