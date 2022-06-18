package com.testspring.springtest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class testSpringBoot {
    @GetMapping("/questions2")
    public String Questions2 () {
        return "Hello Backend Team";
    }
    
    
}
