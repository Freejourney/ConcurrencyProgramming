package com.ddw.eventbus.exception;


import com.ddw.eventbus.context.EventContext;

public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}
