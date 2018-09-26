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
        return "sitemanagerHome";
        //you can change your home and check

        //have to return according to the user login
    }
    @GetMapping(value="/userManagement.html")
    public String registrationPage(){
        return "userManagement";
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
    @GetMapping(value = "/processPayment")
    public String processPayment(){return "processPayment";}

    //site manager
    @GetMapping(value = "/viewRequests.html")
    public String requestView(){return "viewRequests";}
    @GetMapping(value = "/request")
    public String makeRequest(){return "request";}
//    @GetMapping(value = "/sitemanagerhome")
//    public String SiteManager(){return "sitemanagerhome";}



}
