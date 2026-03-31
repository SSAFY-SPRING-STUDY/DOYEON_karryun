package com.example.study.controller;

import com.example.study.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.hi();
    }
}
