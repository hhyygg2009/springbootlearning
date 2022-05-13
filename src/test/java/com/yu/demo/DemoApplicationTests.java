package com.yu.demo;

import com.yu.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    HelloController helloController;

    @Test
    void contextLoads() {
         helloController.hello();
    }

}
