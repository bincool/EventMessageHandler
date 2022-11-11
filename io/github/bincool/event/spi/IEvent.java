/**
* @Description: 消息事件执行的函数接口层.
* @Author wchy，技术交流(891946049).
* @Content: 新增.
* @Version: V1.0.
* @Copyright: 2022 bincool.github.io Inc. All Rights Reserved.
*/
package io.github.bincool.event.spi;

import io.github.bincool.event.EventException;

/**
 * @Description: 消息事件执行的函数接口
 * @Author: wchy，技术交流(891946049).
 */
@FunctionalInterface
public interface IEvent<I, O> {
    /** 事件执行函数 */
    O run(I data) throws EventException;
}
