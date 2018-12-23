package com.ibears.springboot.customer.customer;

import com.ibears.springboot.producer.entity.Order;
import com.rabbitmq.client.Channel;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author xiaoxiong
 * @date 2018/12/22 16:22
 */
@Component
public class OrderReceiver {
    
    @RabbitListener(
          bindings = @QueueBinding(value = @Queue(value = "order-queue", durable = "true"), exchange = @Exchange(name = "order-exchange", declare = "true", type = "topic"), key = "order.*")
    )
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        //消费者操作
        System.out.println("------收到消息  开始消息-------");
        System.out.println("订单号：" + order.getOrderId());
        
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //确认消息
         channel.basicAck(deliveryTag, false);
    }
    
}
