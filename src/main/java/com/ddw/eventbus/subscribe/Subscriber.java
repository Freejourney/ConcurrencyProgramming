package com.ddw.eventbus.subscribe;

import java.lang.reflect.Method;

public class Subscriber {
    private final Object subscribeObject;
    private final Method subscribeMethod;
    private boolean disable = false;

    public Subscriber(Object subscribeObject, Method subscribeMethod) {
        this.subscribeMethod = subscribeMethod;
        this.subscribeObject = subscribeObject;
    }

    public Object getSubscribeObject() {
        return subscribeObject;
    }

    public Method getSubscribeMethod() {
        return subscribeMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
