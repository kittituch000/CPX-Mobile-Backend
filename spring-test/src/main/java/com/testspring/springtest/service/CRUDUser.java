package com.testspring.springtest.service;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.testspring.springtest.model.Users;
import com.testspring.springtest.repository.UsersDao;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;



@Service
@NoArgsConstructor
public class CRUDUser {
    

    public Boolean createUser(Users user,UsersDao userDao) {
        try{
            userDao.save(user);
            return true;
        }
        catch(Exception error){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error about database"+error.getMessage());

        }
       
    } 
    public  Optional<Users> getUser(int id,UsersDao userDao) {
        try{  
            return  userDao.findById(id);
        }
        catch(Exception error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error about id "+error.getMessage());

        }
       
    } 
    public  java.util.List<Users> getUsers(UsersDao userDao) {
        try{
            return  userDao.findAll();
        }
        catch(Exception error){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error about database"+error.getMessage());

        }
       
    } 
    public  boolean deleteUser(int id,UsersDao userDao) {
        try{
            userDao.deleteById(id);
            return true;
        }
        catch(Exception error){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error about database"+error.getMessage());

        }
       
    } 
}
