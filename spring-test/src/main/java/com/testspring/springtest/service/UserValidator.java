package com.testspring.springtest.service;

import java.lang.module.ResolutionException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;



@Service
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)

public class UserValidator {
    String userName;
    String userSurname; 

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }


    public String validatorUser() {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "test1234");
        
    }
    public String validatorUser2() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        
    }
    
}
