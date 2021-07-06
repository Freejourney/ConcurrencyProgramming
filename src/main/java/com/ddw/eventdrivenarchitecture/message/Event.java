package com.ddw.eventdrivenarchitecture.message;

public class Event implements Message{

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
