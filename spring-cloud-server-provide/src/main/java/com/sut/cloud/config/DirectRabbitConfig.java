package com.sut.cloud.config;

import com.stu.cloud.config.RabbitMQDirectConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * @description Direct交换机以及队列的配置类
 * @return
 * @author kt
 * @createDate 2022/7/26
 */
@Configuration
public class DirectRabbitConfig implements BeanPostProcessor {
    /** 创建交换机和队列用的rabbitAdmin对象 */
    @Resource
    private RabbitAdmin rabbitAdmin;

    /** 初始化rabbitAdmin对象 */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        // 当设置为true时，spring才会加载RabbitAdmin这个类
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    /**
     * @description bean后置处理器
     * @param bean
     * @param beanName
     * @return java.lang.Object
     * @author kt
     * @createDate 2022/7/26
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 创建交换机
        rabbitAdmin.declareExchange(rabbitmqDemoDirectExchange());
        // 创建队列
        rabbitAdmin.declareQueue(rabbitmqDemoDirectQueue());

        return null;
    }

    @Bean
    public Queue rabbitmqDemoDirectQueue() {
        /**
         * 1、name:    队列名称
         * 2、durable: 是否持久化
         * 3、exclusive: 是否独享、排外的。如果设置为true，定义为排他队列。则只有创建者可以使用此队列。也就是private私有的。
         * 4、autoDelete: 是否自动删除。也就是临时队列。当最后一个消费者断开连接后，会自动删除。
         **/
        return new Queue(RabbitMQDirectConfig.RABBITMQ_DEMO_TOPIC, true, false, false);
    }

    /**
     * @description 配置MQ交换机
     * @return
     * @author kt
     * @createDate 2022/7/26
     */
    @Bean
    public DirectExchange rabbitmqDemoDirectExchange(){
        //Direct交换机
        return new DirectExchange(RabbitMQDirectConfig.RABBITMQ_DEMO_EXCHANGE, true, false);
    }

    /**
     * @description 绑定交换机和队列，并设置匹配键
     * @return
     * @author kt
     * @createDate 2022/7/26
     */
    @Bean
    public Binding bandDirect(){
        // 链式写法，绑定交换机和队列，并设置匹配键
        return BindingBuilder
                // 绑定队列
                .bind(rabbitmqDemoDirectQueue())
                // 绑定交换机
                .to(rabbitmqDemoDirectExchange())
                // 设置匹配键
                .with(RabbitMQDirectConfig.RABBITMQ_DEMO_DIRECT_ROUTING);
    }
}
