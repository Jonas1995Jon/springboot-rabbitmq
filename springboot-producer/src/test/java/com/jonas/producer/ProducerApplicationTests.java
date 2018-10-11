package com.jonas.producer;

import com.jonas.producer.entity.Order;
import com.jonas.producer.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend1 () throws Exception {
        Order order = new Order();
        order.setId(System.currentTimeMillis() + "");
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderSender.sendOrder(order);
    }

}
