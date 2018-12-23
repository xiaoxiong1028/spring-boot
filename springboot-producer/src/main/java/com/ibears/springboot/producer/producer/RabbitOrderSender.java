package com.ibears.springboot.producer.producer;

import com.ibears.springboot.producer.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author xiaoxiong
 * @date 2018/12/22 15:24
 */
@Component
@Service
public class RabbitOrderSender {
    
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    
    public void send(Order order) throws Exception{
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData(order.getMessageId());
        
        rabbitTemplate.convertAndSend(
              "order-exchange", //exchange
              "order.abcd",//routingKey
              order,//消息实体
              correlationData // 消息唯一id
        );
        
    }
    
    //回调函数  confirm 确认成功
    final RabbitTemplate.ConfirmCallback  confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String s) {
            System.err.println("correlationData"+ correlationData);
            String messageId = correlationData.getId();
            if (ack){
                //TODO 消息发送成功  进行更新状态
                
            }else {
                //TODO 消息放松失败 进行后续具体操作 ： 重试或其他手段
            }
        }
    };
    
    
    
    
}
