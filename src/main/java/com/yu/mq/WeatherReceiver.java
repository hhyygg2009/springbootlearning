package com.yu.mq;

import com.yu.pojo.Weather;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/14 11:51
 */
@Component
@RabbitListener(queues = "apiQ1")//监听的队列名称 TestDirectQueue
public class WeatherReceiver {

    @RabbitHandler
    public void process(Weather testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
