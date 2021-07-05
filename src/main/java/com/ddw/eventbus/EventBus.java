package com.ddw.eventbus;

import com.ddw.eventbus.bus.Bus;
import com.ddw.eventbus.context.EventContext;
import com.ddw.eventbus.demo.SimpleSubscriber1;
import com.ddw.eventbus.exception.EventExceptionHandler;

public class EventBus {

    /**
     * EventBus设计模式仅适用于单节点(单机)，可用于设备监控等场景。
     *
     * EventBus本质上是将订阅者对象以<topic, subscribers>的形式保存在了注册表中，当Bus的post方法被调用时，触发Dispatcher遍历执行订阅者方法。
     *
     * 订阅者方法的参数也需要保持统一，这样post方法的参数才能传递到订阅者方法作为入参执行。
     *
     * 某种程度上来看，类似于回调接口的扩展
     *
     * 拓展：中间件原理
     * @param args
     */
    public static void main(String[] args) {
        Bus bus = new com.ddw.eventbus.bus.EventBus("TestBus", new EventExceptionHandler() {
            @Override
            public void handle(Throwable cause, EventContext context) {
                System.out.println(context.toString());
            }
        });
        bus.register(new SimpleSubscriber1());
//        com.ddw.eventbus.bus.register(new SimpleSubscriber2());
        bus.post("First Hello");
        System.out.println("----------------------");
        bus.post("Hello", "test");
    }
}
