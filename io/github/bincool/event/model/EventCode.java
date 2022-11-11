/**
* @Description: 基于消息的事件注册和事件执行的实体模型层.
* @Author wchy，技术交流(891946049).
* @Content: 新增.
* @Version: V1.0.
* @Copyright: 2022 bincool.github.io Inc. All Rights Reserved.
*/
package io.github.bincool.event.model;

/**
 * @Description: 事件消息code枚举类
 * @Author: wchy，技术交流(891946049).
 */
public enum EventCode {
    /** 用户增加 */
    USER_POST(10011001),
    /** 用户删除 */
    USER_DELETE(10011002),
    /** 用户修改 */
    USER_PUT(10011003),
    /** 用户查询 */
    USER_GET(10011004),

    // 更多的事件配置维护
    ;

    /** 事件消息code，唯一标识事件 */
    private int code;

    /**
     * 私有构造函数，构造枚举类型成员变量
     * 
     * @param code 事件消息code
     */
    private EventCode(int code) {
        this.code = code;
    }

    /**
     * 获取事件消息code的值
     * 
     * @return 事件消息code
     */
    public int value() {
        return code;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}