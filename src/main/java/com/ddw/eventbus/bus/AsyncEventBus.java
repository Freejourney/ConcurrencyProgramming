package com.ddw.eventbus.bus;

import com.ddw.eventbus.exception.EventExceptionHandler;

import java.util.concurrent.ThreadPoolExecutor;

public class AsyncEventBus extends EventBus{
    AsyncEventBus(String busName, EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        super(busName, exceptionHandler, executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor) {
        this("default-topic", null, executor);
    }

    public AsyncEventBus(EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        this("default-topic", exceptionHandler, executor);
    }
}
