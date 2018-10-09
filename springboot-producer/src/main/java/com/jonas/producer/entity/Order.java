package com.jonas.producer.entity;

import java.io.Serializable;

/**
 * Desc：
 * Author Jonas
 * 2018/10/9 17:19
 */
public class Order implements Serializable {

    private String id;

    private String name;

    private String messageId; //存储消息发送的唯一标识

    public Order() {
    }

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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