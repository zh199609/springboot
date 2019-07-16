package com.zl.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息发送方
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    //交换器名称
    @Value("${mq.config.exchange}")
    private String exchangeName;
    //routing路由键
    @Value("${mq.config.queue.room.routing.key}")
    private String roomRoutingKey;

    @Value("${mq.config.queue.equipment.routing.key}")
    private String equipmentRoutingKey;
    /**
     * 发送方法的消息
     */
    public void sendRoom(Map<String,Object> msg) {
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        amqpTemplate.convertAndSend(exchangeName, roomRoutingKey, msg);
    }

    /**
     * 发送方法的消息
     */
    public void sendEquipment(Map<String,Object> msg) {
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        amqpTemplate.convertAndSend(exchangeName, equipmentRoutingKey, msg);
    }

}
