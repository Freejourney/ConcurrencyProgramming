package com.ddw.eventdrivenarchitecture.channel;

import com.ddw.eventdrivenarchitecture.dispatcher.AsyncEventDispatcher;
import com.ddw.eventdrivenarchitecture.message.Event;
import com.ddw.eventdrivenarchitecture.message.InputEvent;
import com.ddw.eventdrivenarchitecture.message.ResultEvent;

import java.util.concurrent.TimeUnit;

public class AsyncInputEventHandler extends AsyncChannel{

    private final AsyncEventDispatcher dispatcher;

    public AsyncInputEventHandler(AsyncEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    // 不同于同步方式实现dispatch，异步方式需要实现handle
    @Override
    protected void handle(Event message) {
        InputEvent inputEvent = (InputEvent) message;
        System.out.printf("X:%d, Y:%d\n", inputEvent.getX(), inputEvent.getY());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = inputEvent.getX() + inputEvent.getY();
        dispatcher.dispatch(new ResultEvent(result));
    }
}
