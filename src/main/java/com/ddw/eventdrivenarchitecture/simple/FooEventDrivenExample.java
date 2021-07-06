package com.ddw.eventdrivenarchitecture.simple;

import java.util.LinkedList;
import java.util.Queue;

public class FooEventDrivenExample {

    /**
     * Event -- EventLoop -- EventHandler
     * @param args
     */
    public static void main(String[] args) {
        Queue<Event> events = new LinkedList<>();
        events.add(new Event("A", "Hello"));
        events.add(new Event("A", "I am EventA"));
        events.add(new Event("B", "Hi"));
        events.add(new Event("B", "I am EventB"));
        EventLoop eventLoop = new EventLoop();
        eventLoop.dispatch(events);
    }
}
