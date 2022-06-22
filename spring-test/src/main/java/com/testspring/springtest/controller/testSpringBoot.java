package com.testspring.springtest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.testspring.springtest.repository.UsersDao;

import antlr.collections.List;

import com.testspring.springtest.model.Users;
import com.testspring.springtest.service.Userss;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/questions10/{id}")
    public String Questions10(@RequestBody Users user , @PathVariable String id ) {   
        user.setUserId(Integer.parseInt(id));
        userDao.save(user);
       return "sucess";

    }
    @PatchMapping("/questions11/{id}")
    public String Questions11(@RequestBody Users user , @PathVariable String id ) { 
        user.setUserId(Integer.parseInt(id));

        if((user.getUserName() == null) & user.getUserSurname() == null)  {
            return "not update";
        } 
        else if(user.getUserName() == null) {
            return "not update";
        } 
        userDao.save(user);
       return "sucess";

    }

    @DeleteMapping("/questions12/{id}")
    public String Questions12( @PathVariable String id ) {   
        userDao.deleteById(Integer.parseInt(id));
       return "delete sucess";

    }
    
    
}
