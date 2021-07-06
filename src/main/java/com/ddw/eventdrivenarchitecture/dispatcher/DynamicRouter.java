package com.ddw.eventdrivenarchitecture.dispatcher;

import com.ddw.eventdrivenarchitecture.channel.Channel;
import com.ddw.eventdrivenarchitecture.message.Message;

/**
 * 对应EventLoop
 * @param <E>
 *
 *     在接口中采用<E extends Message>形式方便接口实现类进行灵活替换
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
