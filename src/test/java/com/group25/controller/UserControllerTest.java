package com.group25.controller;

import com.group25.Main;
import com.group25.entity.User;
import com.group25.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value= UserController.class , secure = false)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {UserController.class, Main.class})
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;

//    User mockUser = new User();
    User mockUser = new User( 54, "Puvipavan", "P", "1111111111", "1111111111", "gggggggg", "Dematagoda, Bathramulla.", "Site Manager", "jvithu2004@gmail.com", "daXl/xbNlMRQ06bBbwQAlg==");

    @Test
    public void getAllUsers() {
    }

    @Test
    public void getUserById() throws Exception {

//        Mockito.when(userService.getUserById(54)).thenReturn(mockUser);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{id}").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
////        String expected = "{employeeID:e001,managerID:e003,allCount:300, defectRate:100}";
//
////        String expected = "{id: 54, fName: Puvipavan, lName: P, mPhone: 1111111111, oPhone: 1111111111, hAddress: gggggggg, wAddress: Dematagoda, Bathramulla., role: Site Manager, email: jvithu2004@gmail.com, password: daXl/xbNlMRQ06bBbwQAlg== }";
//        String expected = "{    \"id\": 54,\n" +
//                "    \"fName\": \"Puvipavan\",\n" +
//                "    \"lName\": \"P\",\n" +
//                "    \"mPhone\": \"1111111111\",\n" +
//                "    \"oPhone\": \"1111111111\",\n" +
//                "    \"hAddress\": \"gggggggg\",\n" +
//                "    \"wAddress\": \"Dematagoda, Bathramulla.\",\n" +
//                "    \"role\": \"Site Manager\",\n" +
//                "    \"email\": \"jvithu2004@gmail.com\",\n" +
//                "    \"password\": \"daXl/xbNlMRQ06bBbwQAlg==\"}";
//
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void getUserByRole() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void addUser() {
    }
}