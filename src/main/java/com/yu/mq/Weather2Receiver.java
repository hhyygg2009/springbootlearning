package com.yu.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yu.pojo.Weather;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "apiQ2")//监听的队列名称 TestDirectQueue
public class Weather2Receiver {

    @RabbitHandler
    public void process(Message testMessage) throws IOException {
        byte []bytes=testMessage.getBody();
        ObjectMapper objectMapper=new ObjectMapper();
        Weather weather=objectMapper.readValue(bytes,Weather.class);


        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
        System.out.println("DirectReceiver消费者收到消息  : " + weather.toString());
    }

}
