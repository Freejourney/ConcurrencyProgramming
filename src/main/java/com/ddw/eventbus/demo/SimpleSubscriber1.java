package com.ddw.eventbus.demo;

import com.ddw.eventbus.context.EventContext;
import com.ddw.eventbus.exception.EventExceptionHandler;
import com.ddw.eventbus.subscribe.Subscribe;
import com.ddw.eventbus.bus.Bus;
import com.ddw.eventbus.bus.EventBus;

public class SimpleSubscriber1 {

    @Subscribe
    public void method1(String message) {
        System.out.println("==com.ddw.eventbus.demo.SimpleSubscriber1==method1==" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println("==com.ddw.eventbus.demo.SimpleSubscriber1==method2==" + message);
    }

    public static void main(String[] args) {
        Bus bus = new EventBus("TestBus", new EventExceptionHandler() {
            @Override
            public void handle(Throwable cause, EventContext context) {
                System.out.println(context.toString());
            }
        });
        bus.register(new SimpleSubscriber1());
//        com.ddw.eventbus.bus.register(new SimpleSubscriber2());
        bus.post("First Hello");
        System.out.println("----------------------");
        bus.post("Hello", "test");
    }
}
