package com.sut.cloud.service;

public interface RabbitMQService {
    /** 发送消息 */
    String sendMsg(String msg) throws Exception;
}
