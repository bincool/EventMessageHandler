/**
* @Description: 基于消息的事件注册和事件执行，实体-函数式程序设计.
* @Author wchy，技术交流(891946049).
* @Content: 新增.
* @Version: V1.0.
* @Copyright: 2022 bincool.github.io Inc. All Rights Reserved.
*/
package io.github.bincool.event;

/**
 * @Description: 事件模块异常类
 * @Author: wchy，技术交流(891946049).
 */
public class EventException extends Exception {

    /**
     * 序列版本号.
     */
    private static final long serialVersionUID = 6537250181271003019L;

    /**
     * 构造函数.
     */
    public EventException() {
        super();
    }

    /**
     * 构造函数.
     * 
     * @param message 异常信息.
     */
    public EventException(String message) {
        super(message);
    }

    /**
     * 构造函数.
     * 
     * @param cause 异常原因.
     */
    public EventException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数.
     * 
     * @param message 异常信息.
     * @param cause   异常原因.
     */
    public EventException(String message, Throwable cause) {
        super(message, cause);
    }

}