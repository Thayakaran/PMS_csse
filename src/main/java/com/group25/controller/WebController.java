package com.group25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value="/")
    public String loginPage(){
        return "login";
    }
    @GetMapping(value="/home.html")
    public String homePage(){
        return "home";
    }
    @GetMapping(value="/registration.html")
    public String registrationPage(){
        return "registration";
    }
}
