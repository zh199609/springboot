package com.zl.service.rmq;

import com.zl.config.EquipmentFailPhoneConfig;
import com.zl.service.phone.MsgService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
/*
    bindings = {}  绑定队列
    @QueueBinding   value:绑定队列的名称
                    exchange:配置交换器
    @Queue  value:配置队列名称
            autoDelete:是否是一个可删除的临时队列
    @Exchange   value:为交换器起个名称
                type：指定交换器类型
 */
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.equipment}", autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.equipment.routing.key}"
        )
)
public class EquipmentReceive {

    @Autowired
    private MsgService msgService;

    @RabbitHandler
    public void process(Map<String, Object> msg) {
        System.out.println("数据：" + msg);
        msgService.sendEquipment((String[]) msg.get("params"), (String) msg.get("phoneNumber"), (Boolean) msg.get("status"));
    }
}
