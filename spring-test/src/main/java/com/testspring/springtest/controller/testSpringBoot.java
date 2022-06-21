package com.testspring.springtest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.testspring.springtest.repository.UsersDao;

import antlr.collections.List;

import com.testspring.springtest.model.Users;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class testSpringBoot {

    @Autowired
    UsersDao userDao;

    @GetMapping("/questions2")
    public String Questions2 () {
        return "Hello Backend Team";
    }

    @PostMapping("/questions7")
    public String postBody(@RequestBody Users user) {
        userDao.save(user);
        return "insert success";

    }

    @GetMapping("/questions8/{id}")
    public Object Questions8(@PathVariable String id) {    
        return  userDao.findById(Integer.parseInt(id));
    }

    @GetMapping("/questions9")
    public Object Questions9() {    
        return  userDao.findAll();
    }
    
    
}
