package com.testspring.springtest.service;

public class Userss {
    int userId;
    String userName;
    String userSurname;    

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
    public void setuserIde(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserSurname() {
        return this.userSurname;
    }
}

