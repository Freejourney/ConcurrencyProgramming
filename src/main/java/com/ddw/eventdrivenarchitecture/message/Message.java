package com.ddw.eventdrivenarchitecture.message;

public interface Message {

    /**
     * 返回Message类型
     *
     * Message对应于Event，每个Message都会有一个特定的Type
     */
    Class<? extends Message> getType();

}
