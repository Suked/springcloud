package com.stu.cloud.config;


/**
 * @description RabbitMQ公共配置类
 * @return
 * @author kt
 * @createDate 2022/7/26
 */
public class RabbitMQDirectConfig {

    /**
     * RabbitMQ的队列主体名称
     */
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";

    /**
     * RabbitMQ的DIRECT交换机名称
     */
    public static final String RABBITMQ_DEMO_EXCHANGE = "rabbitmqDemoExchange";

    /**
     * RabbitMQ的DIRECT交换机名和队列绑定的匹配键
     */
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";

}
