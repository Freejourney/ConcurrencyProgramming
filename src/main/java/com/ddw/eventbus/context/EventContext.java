package com.ddw.eventbus.context;

import java.lang.reflect.Method;

public interface EventContext {
    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
