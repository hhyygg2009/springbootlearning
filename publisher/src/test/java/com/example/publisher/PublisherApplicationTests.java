package com.example.publisher;

import com.example.publisher.pojo.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PublisherApplicationTests {
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

        rabbitTemplate.convertAndSend(
                "weather-direct"
                ,"weather.message"
                ,weather);

//        try {
//            rabbitTemplate.convertAndSend(
//                    "weather-exchange"
//                    ,"weather.message2"
//                    ,objectMapper.writeValueAsBytes(weather));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void createMessage3()   {
        Weather weather=new Weather();
        weather.setCity("123");
        weather.setWeatherDetail("223");
        weather.setId("测试");

        ObjectMapper objectMapper = new ObjectMapper();
        MessageProperties messageProperties=new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        Message message= null;
        try {
            message = rabbitTemplate.getMessageConverter().toMessage(objectMapper.writeValueAsString(weather),messageProperties);
            rabbitTemplate.send(
                    "weather-direct"
                    ,"weather.message"
                    ,message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



//        try {
//            rabbitTemplate.convertAndSend(
//                    "weather-exchange"
//                    ,"weather.message2"
//                    ,objectMapper.writeValueAsBytes(weather));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void createMessage2()   {
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
                    "weather-direct"
                    ,"weather.message2"
                    ,objectMapper.writeValueAsBytes(weather));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void Test(){

        ampqAdmin.declareExchange(new FanoutExchange("weather-exchange"));
        ampqAdmin.declareExchange(new DirectExchange("weather-direct"));
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
        ampqAdmin.declareBinding(new Binding(
                "apiQ1",
                Binding.DestinationType.QUEUE,
                "weather-direct",
                "weather.message",
                null
        ));
        ampqAdmin.declareBinding(new Binding(
                "apiQ2",
                Binding.DestinationType.QUEUE,
                "weather-direct",
                "weather.message2",
                null
        ));


    }


}
