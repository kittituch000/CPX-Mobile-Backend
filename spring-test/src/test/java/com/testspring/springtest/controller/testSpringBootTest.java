package com.testspring.springtest.controller;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.server.ResponseStatusException;

import com.jayway.jsonpath.JsonPath;
import com.testspring.springtest.model.Users;
import com.testspring.springtest.repository.UsersDao;
import com.testspring.springtest.service.CRUDUser;
import com.testspring.springtest.service.Producer;
import com.testspring.springtest.service.UserValidator;

import ch.qos.logback.core.net.ObjectWriter;



@SpringBootTest
@AutoConfigureMockMvc
public class testSpringBootTest {
    Users user = new Users(1,"kittituch","suwsnnsasew");

    @MockBean
	Producer producer;

    @Mock
    Users user2;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CRUDUser createUser;

    @MockBean
    private UserValidator question14_2;

    @MockBean
    UsersDao userDao;


    @Test
    public void getHelloBackend() throws Exception {
      mvc.perform(MockMvcRequestBuilders.get("/questions2"))
          .andExpect(status().isOk())
          .andExpect(content().string(equalTo("Hello Backend Team")));
    }

    @Test
    public void getUser() throws Exception {
      mvc.perform(MockMvcRequestBuilders.get("/questions8/2"))
          .andExpect(status().isOk());
    }

    @Test 
    public void getAllUser() throws Exception {
      mvc.perform(MockMvcRequestBuilders.get("/questions9"))
          .andExpect(status().isOk());
    }


    @Test
    public void createUserFaild() throws Exception{
        when(createUser.createUser(user, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.post("/questions7").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isCreated());
    }

    @Test
    public void question7() throws Exception{
        when(createUser.createUser(user, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.post("/questions7").content("").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }

    @Test
    public void createUserFaildQ15() throws Exception{
        when(createUser.createUser(user, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.post("/questions15").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isCreated());
    }

    @Test
    public void questions10() throws Exception{
        when(createUser.createUser(user, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.put("/questions10/4").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isCreated());
    }

    @Test
    public void questions11() throws Exception{
        doNothing().when(user2).setUserId(anyInt());
        mvc.perform(MockMvcRequestBuilders.patch("/questions11/4").content("").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }

    @Test
    public void questions11_2() throws Exception{
        doNothing().when(user2).setUserName(anyString());
        mvc.perform(MockMvcRequestBuilders.patch("/questions11/4").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isOk());
    }

    @Test
    public void questions11_3() throws Exception{
        doNothing().when(user2).setUserSurname(anyString());
        mvc.perform(MockMvcRequestBuilders.patch("/questions11/4").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isOk());
    }

    @Test
    public void questions12() throws Exception{
        when(createUser.deleteUser(1, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.delete("/questions12/4"))       
        .andExpect(status().isOk());
    }

    @Test
    public void questions12_2() throws Exception{
        when(createUser.deleteUser(1, userDao)).thenThrow(new ResponseStatusException(500,"user and surname is requrie", null));
        mvc.perform(MockMvcRequestBuilders.delete("/questions12/4"))       
        .andExpect(status().isOk());
    }

    @Test
    public void questions13() throws Exception{
        doNothing().when(producer).produce(anyString());
        mvc.perform(MockMvcRequestBuilders.get("/questions13").param("message", "kittituch"))       
        .andExpect(status().isOk());
    }

    @Test
    public void questions14() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/questions14").content("").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }

    @Test
    public void questions14_2() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/questions14").content("{\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }

    @Test
    public void questions14_3() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/questions14").content("{\"userName\":\"KITTITUCH\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }
    @Test
    public void questions14_4() throws Exception{
        doNothing().when(question14_2).validatorUser();
        mvc.perform(MockMvcRequestBuilders.post("/questions14_2").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }

    @Test
    public void questions14_5() throws Exception{
        doNothing().when(question14_2).validatorUser();
        mvc.perform(MockMvcRequestBuilders.post("/questions14_2").content("{\"userName\":\"KITTITUCH\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }

    @Test
    public void questions15() throws Exception{
        when(createUser.createUser(user, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.post("/questions15").content("{\"userName\":\"KITTITUCH\",\"userSurname\":\"SUWANNASRi\"}").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isCreated());
    }

    @Test
    public void questions15_2() throws Exception{
        when(createUser.createUser(user, userDao)).thenReturn(true);
        mvc.perform(MockMvcRequestBuilders.post("/questions15").content("").contentType(MediaType.APPLICATION_JSON))       
        .andExpect(status().isBadRequest());
    }





}
