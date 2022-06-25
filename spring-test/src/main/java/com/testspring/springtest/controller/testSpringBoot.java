package com.testspring.springtest.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.testspring.springtest.repository.UsersDao;

import lombok.AllArgsConstructor;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.testspring.springtest.model.Users;
import com.testspring.springtest.service.CRUDUser;
import com.testspring.springtest.service.Customer2;
import com.testspring.springtest.service.Producer;
import com.testspring.springtest.service.UserValidator;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@AllArgsConstructor
public class testSpringBoot {
    @Autowired
	private Producer producer;

    @Autowired
    UsersDao userDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/questions2")
    public String Questions2 () {

        return "Hello Backend Team";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/questions7")
    public void postBody(@RequestBody Users user) {
        CRUDUser createUser = new CRUDUser();
        createUser.createUser(user, userDao);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/questions8/{id}")
    public Optional<Users> Questions8(@PathVariable String id) {  
        CRUDUser crudUser = new CRUDUser();  
        return  crudUser.getUser(Integer.parseInt(id), userDao);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/questions9")
    public java.util.List<Users> Questions9() {    
        CRUDUser crudUser = new CRUDUser(); 

        return  crudUser.getUsers(userDao);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/questions10/{id}")
    public void Questions10(@RequestBody Users user , @PathVariable String id ) { 
        CRUDUser createUser = new CRUDUser();  
        user.setUserId(Integer.parseInt(id));
        createUser.createUser(user, userDao);

    }
    @PatchMapping("/questions11/{id}")
    public void Questions11(@RequestBody Users user , @PathVariable String id ) { 
        user.setUserId(Integer.parseInt(id));
        CRUDUser crudUser = new CRUDUser(); 
        Optional<Users> userUpdate  = crudUser.getUser(Integer.parseInt(id), userDao);

        if((user.getUserName() == null) & user.getUserSurname() == null)  {
            throw new ResponseStatusException(400,"user and surname is requrie", null);
        } 

        else if(user.getUserName() == null) {
            user.setUserName(userUpdate.get().getUserName());
            crudUser.createUser(user, userDao);
        } 

        else if(user.getUserSurname() == null) {
            user.setUserSurname(userUpdate.get().getUserSurname());
            crudUser.createUser(user, userDao);
        } 
    }
    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/questions12/{id}")
    public void Questions12( @PathVariable String id ) {   
        CRUDUser crudUser = new CRUDUser();
        crudUser.deleteUser(Integer.parseInt(id), userDao);

    }

    @ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/questions13")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		producer.produce(message);
	}

    @PostMapping("/questions14")
    public void questions14(@RequestBody Users user ) {

        if((user.getUserName() == null) & user.getUserSurname() == null)  {
            throw new ResponseStatusException(400,"user and surname is requrie", null);
        } 

        else if(user.getUserName() == null) {
            throw new ResponseStatusException(400,"username is requrie", null);
        } 

        else if(user.getUserSurname() == null) {
            throw new ResponseStatusException(400,"surname is requrie", null);
        } 
    
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/questions14_2")
    public void questions14_2() {
        UserValidator question14_2 = new UserValidator();
        try{
            question14_2.validatorUser2();   
        }catch(ResponseStatusException error){

            throw new ResponseStatusException(error.getStatus(),error.getMessage());
        }
    }

    @PostMapping("/questions15")
    @ResponseStatus(HttpStatus.CREATED)
    public void questions15(@RequestBody Users user) {
        CRUDUser createUser = new CRUDUser();
        createUser.createUser(user, userDao);
    }

}
