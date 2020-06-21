package com.forever.zhb.common.thread.disruptor.factory;

import com.forever.zhb.common.thread.disruptor.event.LongEvent;
import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
