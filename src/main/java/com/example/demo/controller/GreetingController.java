package com.example.demo.controller;

import com.example.demo.UserInfo;
import com.example.demo.service.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/greetingPost", method = RequestMethod.POST)
    public Greeting greetingPost(@RequestBody UserInfo userInfo){
        return new Greeting(counter.incrementAndGet(), String.format(template, userInfo.getName()));
    }

    @RequestMapping(value = "/greet")
    public String greet(){
        return greetingService.greet();
    }
}
