package com.ddw.eventdrivenarchitecture.channel;

import com.ddw.eventdrivenarchitecture.message.ResultEvent;

public class ResultEventHandler implements Channel<ResultEvent> {

    @Override
    public void dispatch(ResultEvent message) {
        System.out.println("The result is: " + message.getResult());
    }

}
