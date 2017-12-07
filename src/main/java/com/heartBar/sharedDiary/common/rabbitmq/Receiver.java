package com.heartBar.sharedDiary.common.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangxy 2017/11/23 10:15
 */
@Component
@RabbitListener(queues = "helloQueue")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
