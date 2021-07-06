package com.ddw.eventdrivenarchitecture.dispatcher;

import com.ddw.eventdrivenarchitecture.MessageMatcherException;
import com.ddw.eventdrivenarchitecture.channel.AsyncChannel;
import com.ddw.eventdrivenarchitecture.channel.Channel;
import com.ddw.eventdrivenarchitecture.message.Event;
import com.ddw.eventdrivenarchitecture.message.Message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AsyncEventDispatcher implements DynamicRouter<Event> {

    // 使用线程安全的ConcurrentHashMap替换HashMap
    private final Map<Class<? extends Message>, AsyncChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {
        // 在AsyncEventDispatcher中，Channel必须是AsyncChannel类型
        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("The channel must be AsyncChannel Type.");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(Event message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Can't match the channel for the type : [" + message.getType() + "]");
        }
    }

    public void shutdown() {
        routerTable.values().forEach(AsyncChannel::stop);
    }
}
