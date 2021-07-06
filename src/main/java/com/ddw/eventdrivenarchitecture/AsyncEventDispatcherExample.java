package com.ddw.eventdrivenarchitecture;

import com.ddw.eventdrivenarchitecture.channel.AsyncInputEventHandler;
import com.ddw.eventdrivenarchitecture.channel.AsyncResultEventHandler;
import com.ddw.eventdrivenarchitecture.dispatcher.AsyncEventDispatcher;
import com.ddw.eventdrivenarchitecture.message.InputEvent;
import com.ddw.eventdrivenarchitecture.message.ResultEvent;

public class AsyncEventDispatcherExample {

    /**
     * Event于Channel是分离的，所以InputEvent既可以给InputEventHandler处理也可以给AsyncInputEventHandler处理
     *
     * @param args
     */
    public static void main(String[] args) {
        AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(InputEvent.class, new AsyncInputEventHandler(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new AsyncResultEventHandler());
        dispatcher.dispatch(new InputEvent(4, 6));
    }
}
