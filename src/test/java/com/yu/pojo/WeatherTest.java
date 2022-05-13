package com.yu.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/14 11:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class WeatherTest {
    @Autowired
    AmqpAdmin ampqAdmin;
//    RabbitAdmin rabbitAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void createMessage()   {
        Weather weather=new Weather();
        weather.setCity("123");
        weather.setWeatherDetail("223");
        weather.setId("测试");

        ObjectMapper objectMapper = new ObjectMapper();

//        rabbitTemplate.convertAndSend(
//                "weather-exchange"
//                ,"weather.message"
//                ,weather);
        try {
            rabbitTemplate.convertAndSend(
                    "weather-exchange"
                    ,"weather.message"
                    ,objectMapper.writeValueAsBytes(weather));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test(){

        ampqAdmin.declareExchange(new FanoutExchange("weather-exchange"));
        ampqAdmin.declareQueue(new Queue("apiQ1"));
        ampqAdmin.declareQueue(new Queue("apiQ2"));
        ampqAdmin.declareBinding(new Binding(
                        "apiQ1",
                        Binding.DestinationType.QUEUE,
                        "weather-exchange",
                        "weather.message",
                        null
                ));
        ampqAdmin.declareBinding(new Binding(
                "apiQ2",
                Binding.DestinationType.QUEUE,
                "weather-exchange",
                "weather.message2",
                null
        ));


    }


}