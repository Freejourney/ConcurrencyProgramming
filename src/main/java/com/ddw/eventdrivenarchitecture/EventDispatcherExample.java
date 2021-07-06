package com.ddw.eventdrivenarchitecture;

import com.ddw.eventdrivenarchitecture.channel.InputEventHandler;
import com.ddw.eventdrivenarchitecture.channel.ResultEventHandler;
import com.ddw.eventdrivenarchitecture.message.InputEvent;
import com.ddw.eventdrivenarchitecture.message.ResultEvent;

public class EventDispatcherExample {

    /**
     * Event Driven Architecture更像是事先铺好了管道(Event-->Channel)，Event就好像水一样，铺好管道让水进来后按照预定设计的管道进行流动
     *
     * EventDispatcher不关心Event的先后顺序，所以提供给InputEventHandler的dispatcher使得数据流动了起来，可以扩展延伸更多更长的数据加工
     *
     * Message -- Event
     * Channel -- EventHandler
     * DynamicRouter -- EventDispatcher -- EventLoop
     *
     * EDA与EventBus不同在于EventBus是消息推送给订阅者的形式，而EDA则是消息的流处理
     * 
     * @param args
     */
    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(InputEvent.class, new InputEventHandler(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());
        dispatcher.dispatch(new InputEvent(1, 2));
        dispatcher.dispatch(new ResultEvent(100));
    }
}
