package com.testspring.springtest.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.testspring.springtest.model.Users;

@SpringBootTest
@AutoConfigureMockMvc
public class UserValidatorTest {
    UserValidator userValidator = new UserValidator();

    @MockBean
    private UserValidator userValidator_2;

    @Test
    public void setUserNameTest(){
       userValidator.setUserName("kittituch");

    }

    @Test
    public void setUserSurnameTest(){
       userValidator.setUserSurname("Suwannasri");

    }

    
}
