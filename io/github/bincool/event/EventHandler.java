/**
* @Description: 基于消息的事件注册和事件执行，实体-函数式程序设计.
* @Author wchy，技术交流(891946049).
* @Content: 新增.
* @Version: V1.0.
* @Copyright: 2022 bincool.github.io Inc. All Rights Reserved.
*/
package io.github.bincool.event;

import java.util.HashMap;
import java.util.Map;

import io.github.bincool.event.model.EventCode;
import io.github.bincool.event.model.EventMessage;
import io.github.bincool.event.spi.IEvent;

/**
 * @Description: 基于消息的事件注册和事件执行的工具类
 * @Author: wchy，技术交流(891946049).
 */
public class EventHandler {
    /** 事件缓存 */
    private static final Map<EventCode, IEvent<?, ?>> EVENTS = new HashMap<EventCode, IEvent<?, ?>>();

    /**
     * 注册事件
     * 
     * @param <I>   输入类型
     * @param <O>   输出类型
     * @param code  消息事件code
     * @param event 事件
     * @throws EventException 事件模块异常
     */
    public static <I, O> void register(EventCode code, IEvent<I, O> event) throws EventException {
        // 检查事件是否已经存在了
        if (exists(code)) {
            throw new EventException("the event is exists");
        }

        // 将事件加入事件缓存
        EVENTS.put(code, event);
    }

    /**
     * 执行事件
     * 
     * @param <I>     输入类型
     * @param <O>     输出类型
     * @param message 消息
     * @return 事件执行的结果
     * @throws EventException 事件模块异常
     */
    public static <I, O> O run(EventMessage<I> message) throws EventException {
        // 检查事件是否不存在
        if (!exists(message.getCode())) {
            throw new EventException("the event is not eixsts");
        }

        // 从缓存中获取事件
        @SuppressWarnings("unchecked")
        IEvent<I, O> event = (IEvent<I, O>) EVENTS.get(message.getCode());

        // 执行事件
        return event.run(message.getData());
    }

    /**
     * 执行事件
     * 
     * @param <I>  输入类型
     * @param <O>  输出类型
     * @param code 消息事件code
     * @param data 消息事件数据
     * @return 事件执行的结果
     * @throws EventException 事件模块异常
     */
    public static <I, O> O run(EventCode code, I data) throws EventException {
        return run(new EventMessage<>(code, data));
    }

    /**
     * 通过消息事件code查询事件是否存在
     * 
     * @param code 消息事件code
     * @return true：事件存在；false：事件不存在
     */
    private static boolean exists(EventCode code) {
        return null != EVENTS.get(code);
    }
}