package com.ddw.eventbus.bus;

public interface Bus {

    // 将某个对象注册到Bus上，从此以后该类就成为Subscriber
    void register(Object subscriber);

    void unregister(Object subscriber);

    // 提交Event到默认的topic
    void post(Object event);

    void post(Object event, String topic);

    // 关闭该bus
    void close();

    String getBusName();
}
