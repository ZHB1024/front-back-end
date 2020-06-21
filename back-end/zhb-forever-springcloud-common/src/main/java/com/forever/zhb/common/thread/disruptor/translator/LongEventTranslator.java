package com.forever.zhb.common.thread.disruptor.translator;

import com.forever.zhb.common.thread.disruptor.event.LongEvent;
import com.lmax.disruptor.EventTranslatorOneArg;

public class LongEventTranslator implements EventTranslatorOneArg<LongEvent, Long> {

    @Override
    public void translateTo(LongEvent event, long sequence, Long arg0) {
        event.setNumber(arg0);
    }

}
