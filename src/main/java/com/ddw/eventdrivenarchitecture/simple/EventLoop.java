package com.ddw.eventdrivenarchitecture.simple;

import java.util.Queue;

public class EventLoop {

    public void dispatch(Queue<Event> events) {
        Event event;
        while (!events.isEmpty()) {
            event = events.remove();
            switch (event.getType()) {
                case "A":
                    EventHandler.handleEventA(event);
                    break;
                case "B":
                    EventHandler.handleEventB(event);
                    break;
            }
        }
    }
}
