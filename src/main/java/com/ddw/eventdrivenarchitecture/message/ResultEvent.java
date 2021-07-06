package com.ddw.eventdrivenarchitecture.message;

public class ResultEvent extends Event{

    private final int result;

    public ResultEvent(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

}
