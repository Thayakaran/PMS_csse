package com.group25.controller;

import com.group25.entity.User;
import com.group25.mailService.MailService;
import com.group25.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    MailService mailservice;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "role/{role}", method = RequestMethod.GET)
    public Collection<User> getUserByRole(@PathVariable("role") String role){
        return userService.getUserByRole(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") int id){
        return userService.deleteUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody User user){
        String res = userService.addUser(user);
        if(res == "{\"success\" : true}"){
            mailservice.sendMailAboutUserRegistration(user);
        }
        return  res;
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }
}
