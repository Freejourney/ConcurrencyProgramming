package com.ddw.eventdrivenarchitecture.channel;

import com.ddw.eventdrivenarchitecture.message.Message;

public interface Channel<E extends Message> {

    /**
     * dispatch方法负责Message的调度, 对应于EventHandler
     */
    void dispatch(E message);

}
