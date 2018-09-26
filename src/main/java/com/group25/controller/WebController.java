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

    //// Manager Interfaces
    @GetMapping(value="/userManagement.html")
    public String userManagementPage(){
        return "userManagement";
    }
    @GetMapping(value="/siteManagement.html")
    public String siteManagementPage(){
        return "siteManagement";
    }

    //// Supplier Interface
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

    //// Site Manager Interface
    @GetMapping(value = "/viewRequests.html")
    public String requestView(){return "viewRequests";}
    @GetMapping(value = "/request.html")
    public String makeRequest(){return "request";}



}
