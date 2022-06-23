package com.testspring.springtest.service;
import javax.net.ssl.HttpsURLConnection;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testspring.springtest.model.Users;
import com.testspring.springtest.repository.UsersDao;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class CreateUser {

    public String createUser(Users user,UsersDao userDao) {
        try{
            userDao.save(user);
            return "";
        }
        catch(Exception error){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error about database .savw"+error.getMessage());

        }
       
    } 
}
