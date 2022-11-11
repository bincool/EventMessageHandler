/**
* @Description: 基于消息的事件注册和事件执行的实体模型层.
* @Author wchy，技术交流(891946049).
* @Content: 新增.
* @Version: V1.0.
* @Copyright: 2022 bincool.github.io Inc. All Rights Reserved.
*/
package io.github.bincool.event.model;

import java.io.Serializable;

/**
 * @Description: 事件消息实体
 * @Author: wchy，技术交流(891946049).
 */
public class EventMessage<T> implements Serializable {
    /** 事件消息code */
    private EventCode code;

    /** 事件消息数据 */
    private T data;

    /**  */
    public EventMessage() {
        super();
    }

    /**
     * 事件消息实体构造函数
     * @param code 事件消息code
     * @param data 事件消息数据
     */
    public EventMessage(EventCode code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    /**
     * 获取事件消息code
     * @return
     */
    public EventCode getCode() {
        return code;
    }

    /**
     * 设置事件消息code
     * @param code
     */
    public void setCode(EventCode code) {
        this.code = code;
    }

    /**
     * 获取事件消息数据
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * 设置事件消息数据
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventMessage [code=" + code + ", data=" + data + "]";
    }
}
