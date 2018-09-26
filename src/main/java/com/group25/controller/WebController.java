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
        return "managementHome";
        //you can change your home and check

        //have to return according to the user login
    }
    @GetMapping(value="/registration.html")
    public String registrationPage(){
        return "registration";
    }


    @GetMapping(value = "/orderDetails.html")
    public String orderDetailsPage(){return "orderDetails";}
    @GetMapping(value = "/invoice.html")
    public String invoicePage(){return "invoice";}
    @GetMapping(value = "/goodReceipt.html")
    public String goodReceiptPage(){return "goodReceipt";}
    @GetMapping(value = "/paymentSummery.html")
    public String paymentSummeryPage(){return "paymentSummery";}
    @GetMapping(value = "/supplierProfile.html")
    public String supplierProfilePage(){return "supplierProfile";}
    @GetMapping(value = "/payments")
    public String paymentDetails(){return "payments";}


}
