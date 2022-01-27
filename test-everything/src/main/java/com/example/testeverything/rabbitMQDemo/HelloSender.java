package com.example.testeverything.rabbitMQDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yujie_Zhao
 * @date 2022/1/21 15:42
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "hello" + date;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("q_hello", context);
    }
}
