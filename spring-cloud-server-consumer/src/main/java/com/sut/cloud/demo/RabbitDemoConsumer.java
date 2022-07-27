package com.sut.cloud.demo;

import com.stu.cloud.config.RabbitMQDirectConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/** 队列名称，可以写多个 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQDirectConfig.RABBITMQ_DEMO_TOPIC))
public class RabbitDemoConsumer {

    @RabbitHandler
    public void process(Map map){
        System.out.println("消费者RabbitmqDemoConsumer从RabbitMq服务端消费信息：" + map.toString());
    }
}
