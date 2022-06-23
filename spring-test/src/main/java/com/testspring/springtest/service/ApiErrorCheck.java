package com.testspring.springtest.service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ApiErrorCheck extends Exception {
   
   
    public ApiErrorCheck(Number HttpStatus ,String error) {
        super(error);
    }  

    
}
