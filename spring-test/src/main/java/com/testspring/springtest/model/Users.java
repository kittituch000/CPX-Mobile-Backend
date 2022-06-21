package com.testspring.springtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;
    String userName;
    String userSurname;
    Users() {}
    public String getUserName() {
        return this.userName;
    }

    public String getUserSurname() {
        return this.userSurname;
    }
    
}

