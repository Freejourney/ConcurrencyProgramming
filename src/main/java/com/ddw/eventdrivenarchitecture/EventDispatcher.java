package com.ddw.eventdrivenarchitecture;

import com.ddw.eventdrivenarchitecture.channel.Channel;
import com.ddw.eventdrivenarchitecture.message.Message;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher implements DynamicRouter<Message> {

    // 用于保存Channel和Message的对应关系
    private final Map<Class<? extends Message>, Channel> routerTable;

    public EventDispatcher() {
        this.routerTable = new HashMap<>(); // 线程不安全
    }

    @Override
    public void dispatch(Message message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Can't match the channel for the type : [" + message.getType() + "]");
        }
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        this.routerTable.put(messageType, channel);
    }
}
