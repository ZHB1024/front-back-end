package com.forever.zhb.common.thread.disruptor;

import java.util.concurrent.Executors;

import com.forever.zhb.common.thread.disruptor.consumer.Consumer01;
import com.forever.zhb.common.thread.disruptor.event.LongEvent;
import com.forever.zhb.common.thread.disruptor.factory.LongEventFactory;
import com.forever.zhb.common.thread.disruptor.translator.LongEventTranslator;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class Main {

    public static void main(String[] args) {
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        int bufferSize = 1024*1024;
        
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,bufferSize, 
                Executors.defaultThreadFactory(),ProducerType.SINGLE,new BlockingWaitStrategy());

        registerCnosumers(disruptor);
        registerProducer(disruptor);
        
    }
    
    private static void registerCnosumers(Disruptor<LongEvent> disruptor) {
        disruptor.handleEventsWithWorkerPool(new Consumer01(),new Consumer01());
        disruptor.start();
    }
    
    private static void registerProducer(Disruptor<LongEvent> disruptor) {
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        while (true) {
            ringBuffer.publishEvent(new LongEventTranslator(),10L);
        }
        
    }
    
    

}
