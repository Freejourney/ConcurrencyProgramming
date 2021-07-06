package com.ddw.eventdrivenarchitecture.simple;

public class EventHandler {

    public static void handleEventA(Event event) {
        System.out.println(event.getData().toLowerCase());
    }

    public static void handleEventB(Event event) {
        System.out.println(event.getData().toUpperCase());
    }
}
