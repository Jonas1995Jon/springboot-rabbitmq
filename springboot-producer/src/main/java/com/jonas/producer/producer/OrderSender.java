package com.jonas.producer.producer;

import com.jonas.producer.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Desc：生产者
 * Author Jonas
 * 2018/10/9 17:24
 */

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order) throws Exception {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange", //change
                "order.abcd", //routingKey
                 order, //消息体内容
                 correlationData); //correlationData 消息唯一id
    }

}
