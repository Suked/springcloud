package com.sut.cloud.service.impl;

import com.stu.cloud.config.RabbitMQDirectConfig;
import com.sut.cloud.service.RabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {
    //日期格式化
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) throws Exception{
        try {
            String smgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String sendTime = sdf.format(new Date());
            Map<String, Object> map = new HashMap<>();
            map.put("smgId", smgId);
            map.put("sendTime", sendTime);
            map.put("msg", msg);
            rabbitTemplate.convertAndSend(RabbitMQDirectConfig.RABBITMQ_DEMO_EXCHANGE, RabbitMQDirectConfig.RABBITMQ_DEMO_DIRECT_ROUTING, map);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
