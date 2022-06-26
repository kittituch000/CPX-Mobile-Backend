package com.testspring.springtest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.catalina.User;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.testspring.springtest.model.Users;
import com.testspring.springtest.repository.UsersDao;

@SpringBootTest
@AutoConfigureMockMvc
public class CRUDUserTest {
    Users user = new Users(1,"kittituch","suwsnnsasew");

    @Mock
    User user2;

    @Autowired
    private MockMvc mvc;

    @Spy
    @InjectMocks
    private CRUDUser crudUser;
    
    @Autowired
    @Mock
    UsersDao userDao;
    
    @Test
    public void  testcreateUser(){
        when(userDao.save(user)).thenReturn(user);
        boolean success = crudUser.createUser(user, userDao);

        assertEquals(true, success);

    }

}
