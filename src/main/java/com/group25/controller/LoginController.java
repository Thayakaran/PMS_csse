package com.group25.controller;

import com.group25.entity.Login;
import com.group25.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Login getUserById(@PathVariable("email") String email){

        Login login = loginService.getUserCredentials(email);

        return login;



    }

}
