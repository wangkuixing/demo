package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.controller.GreetingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingTest {

    @Autowired
    private GreetingController greetingController;

    //初始化测试
    @Test
    public void contextLoads(){
        assertThat(greetingController).isNotNull();
    }
}
