package com.example.demo;

import com.example.demo.controller.GreetingController;
import com.example.demo.service.GreetingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(GreetingController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GreetingService service;

    //controller单测
    @Test
    public void getHello() throws Exception {
        Mockito.when(service.greet()).thenReturn("Hello Mock!");
        mvc.perform(MockMvcRequestBuilders.get("/greet"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello Mock!")));
    }
}
