package com.ddw.eventdrivenarchitecture;

import com.ddw.eventdrivenarchitecture.channel.Channel;
import com.ddw.eventdrivenarchitecture.message.Message;

/**
 * 对应EventLoop
 * @param <E>
 */
public interface DynamicRouter<E extends Message> {

    /**
     * 针对每一种Message类型注册相关的Channel，只有找到合适的Channel才会处理该Message
     */
    void registerChannel(Class<? extends E> messageType, Channel<? extends E> channel);

    /**
     * 为相应的Channel分配Message
     */
    void dispatch(E message);

}
