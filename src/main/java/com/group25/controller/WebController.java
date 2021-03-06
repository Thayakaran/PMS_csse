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
        return "login";
        //you can change your home and check

        //have to return according to the user login
    }

    //// Manager Interfaces
    @GetMapping(value="/managementHome")
    public String managementHomePage(){
        return "managementHome";
    }
    @GetMapping(value="/userManagement")
    public String userManagementPage(){
        return "userManagement";
    }
    @GetMapping(value="/siteManagement")
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

    @GetMapping(value = "/supplierMeterial.html")
    public String supplierMeterialPage(){return "supplierMeterial";}
    @GetMapping(value = "/supplierHome.html")
    public String supplierHomePage(){return "supplierHome";}
    @GetMapping(value = "/editStatus.html")
    public String editPage(){return "editStatus";}


    //// Site Manager Interface
    @GetMapping(value = "/viewRequests.html")
    public String requestView(){return "viewRequests";}
    @GetMapping(value = "/request.html")
    public String makeRequest(){return "request";}
    @GetMapping(value="/sitemanagerHome.html")
    public String siteManagerPage(){
        return "sitemanagerHome";
    }
    @GetMapping(value="/manageRequest.html")
    public String manageRequest(){
        return "manageRequest";
    }


    //// Account Staff Interface
    @GetMapping(value = "/payments")
    public String paymentDetails(){return "payments";}
    @GetMapping(value = "/pay")
    public String processPayment(){return "processPayment";}
    @GetMapping(value = "/accoundantHome.html")
    public String accoundantHome(){return "accoundantHome";}


}
