package com.ddw.eventdrivenarchitecture.channel;

import com.ddw.eventdrivenarchitecture.dispatcher.EventDispatcher;
import com.ddw.eventdrivenarchitecture.message.InputEvent;
import com.ddw.eventdrivenarchitecture.message.ResultEvent;

public class InputEventHandler implements Channel<InputEvent>{

    private final EventDispatcher dispatcher;

    public InputEventHandler(EventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void dispatch(InputEvent message) {
        System.out.printf("X:%d, Y:%d\n", message.getX(), message.getY());
        int result = message.getX() + message.getY();
        // 产生了新的event并提交给了EventDispatcher进行分发
        dispatcher.dispatch(new ResultEvent(result));
    }
}
