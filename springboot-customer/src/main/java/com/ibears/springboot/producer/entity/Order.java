package com.ibears.springboot.producer.entity;

import java.io.Serializable;

/**
 * @author xiaoxiong
 * @date 2018/12/22 14:25
 */
public class Order implements Serializable{
    
    private static final long serialVersionUID = 5862941467077065519L;
    
    
    private String orderId;
    
    private String name;
    
    /**
     * 存储消息发送的唯一标识
     */
    private String messageId;
    
    
    public Order() {
    }
    
    public Order(String orderId, String name, String messageId) {
        this.orderId = orderId;
        this.name = name;
        this.messageId = messageId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMessageId() {
        return messageId;
    }
    
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
