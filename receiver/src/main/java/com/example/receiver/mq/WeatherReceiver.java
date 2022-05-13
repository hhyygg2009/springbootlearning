package com.example.receiver.mq;

import com.example.publisher.pojo.Weather;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/14 11:51
 */
@Component
@RabbitListener(queues = "apiQ1")//监听的队列名称 TestDirectQueue
public class WeatherReceiver {

    @RabbitHandler
    public void process(Weather weather) {
//        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
//        byte []bytes=testMessage.getBody();

        System.out.println("DirectReceiver消费者收到消息  : " + weather);
    }

}
