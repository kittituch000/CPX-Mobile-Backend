package com.testspring.springtest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testspring.springtest.repository.UsersDao;

import antlr.collections.List;
import lombok.extern.log4j.Log4j2;

import com.testspring.springtest.model.Users;
import com.testspring.springtest.service.Customer;
import com.testspring.springtest.service.Producer;
import com.testspring.springtest.service.UserValidator;
import com.testspring.springtest.service.Userss;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Log4j2
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

    @Autowired
	private Producer producer;

	@GetMapping(value = "/questions13")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producer.produce(message);
	}

    @PostMapping("/questions14")
    public String questions14() {
        UserValidator question14 = new UserValidator();
        try{
            question14.validatorUser();
            return "insert success2";
        }catch(ResponseStatusException error)
        {

            throw new ResponseStatusException(error.getStatus(),error.getMessage());
        }
        

    }
    @PostMapping("/questions14_2")
    public String questions14_2() {
        UserValidator question14_2 = new UserValidator();
        try{
            question14_2.validatorUser2();
            return "insert success2";
        }catch(ResponseStatusException error)
        {

            throw new ResponseStatusException(error.getStatus(),error.getMessage());
        }
        

    }


    
    
}
