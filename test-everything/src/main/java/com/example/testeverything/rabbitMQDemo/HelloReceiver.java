package com.example.testeverything.rabbitMQDemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Yujie_Zhao
 * @date 2022/1/21 15:46
 */

@Component
@RabbitListener(queues = "q_hello")
public class HelloReceiver {

    public void process(String hello) {
        System.out.println("Receiver : " + hello);

    }
}
