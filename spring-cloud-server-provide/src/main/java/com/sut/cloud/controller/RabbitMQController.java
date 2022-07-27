package com.sut.cloud.controller;

import com.sut.cloud.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {
    @Autowired
    private RabbitMQService rabbitMQService;

    /** 发送消息 */
    @PostMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "msg")String msg) throws Exception {
        return rabbitMQService.sendMsg(msg);
    }
}
