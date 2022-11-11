package io.github.bincool.event.test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import io.github.bincool.event.EventException;
import io.github.bincool.event.EventHandler;
import io.github.bincool.event.model.EventCode;
import io.github.bincool.event.model.EventMessage;
import io.github.bincool.event.spi.IEvent;

public class Main {
    /**
     * @param args
     * @throws EventException
     */
    public static void main(String[] args) throws EventException {
        // 用户缓存
        Map<Integer, AbstractMap.SimpleEntry<Integer, String>> users = new HashMap<Integer, AbstractMap.SimpleEntry<Integer, String>>();

        // 事件注册：用户新增
        EventHandler.register(EventCode.USER_POST, new IEvent<AbstractMap.SimpleEntry<Integer, String>, String>() {

            @Override
            public String run(AbstractMap.SimpleEntry<Integer, String> user) throws EventException {
                users.put(user.getKey(), user);
                return "hello " + user.getValue();
            }

        });

        // 事件注册：用户查询
        IEvent<Integer, AbstractMap.SimpleEntry<Integer, String>> event = (id) -> {
            return users.get(id);
        };
        EventHandler.register(EventCode.USER_GET, event);

        // 事件执行：用户新增
        String resultStr = EventHandler
                .run(new EventMessage<>(EventCode.USER_POST, new AbstractMap.SimpleEntry<Integer, String>(1, "Jack")));
        System.out.println(resultStr);

        // 事件执行：用户查询
        AbstractMap.SimpleEntry<Integer, String> user = EventHandler.run(new EventMessage<>(EventCode.USER_GET, 1));
        System.out.println("user id = " + user.getKey() + ", user name is " + user.getValue());
    }
}
