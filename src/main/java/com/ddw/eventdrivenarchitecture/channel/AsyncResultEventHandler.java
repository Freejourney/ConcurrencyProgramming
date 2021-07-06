package com.ddw.eventdrivenarchitecture.channel;

import com.ddw.eventdrivenarchitecture.message.Event;
import com.ddw.eventdrivenarchitecture.message.ResultEvent;

import java.util.concurrent.TimeUnit;

public class AsyncResultEventHandler extends AsyncChannel{

    @Override
    protected void handle(Event message) {
        ResultEvent resultEvent = (ResultEvent) message;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The result is: " + resultEvent.getResult());
    }

}
