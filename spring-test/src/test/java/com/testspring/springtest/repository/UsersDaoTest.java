package com.testspring.springtest.repository;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersDaoTest {
           
    @Mock
    UsersDao usersDao;

    @Test
    public void userDao() {

       }
    
}
