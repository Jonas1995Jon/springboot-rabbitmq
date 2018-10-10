package com.jonas.consumer.consumer;

import com.jonas.consumer.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * Desc：
 * Author Jonas
 * 2018/10/10 15:06
 */
public class OrderReceiver {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(
                            value = "order-queue",
                            durable = "true"
                    ),
                    exchange = @Exchange(
                            name = "order-exchange", durable = "ture", type = "topic"
                    ),
                    key = "order.*"
            )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        //消费者操作
        System.out.println("------收到消息，开始消费------");
        System.out.println("订单 ID：" + order.getId());

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //
        channel.basicAck(deliveryTag, false);
    }

}
