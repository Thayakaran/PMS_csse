package com.group25.controller;


import com.group25.entity.Invoice;

import com.group25.mailService.MailService;
import com.group25.service.InvoiceService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    MailService mailservice;

    // get all payment details which are not paid

    @RequestMapping(value = "/unpaid", method = RequestMethod.GET)
    public Collection<Invoice> getAllUnPaidInvoices(){

        return invoiceService.getAllUnPaidInvoices();

    }

        // get all payment details which are paid
    @RequestMapping(value = "/paid", method = RequestMethod.GET)
    public Collection<Invoice> getAllPaidInvoices(){

        return invoiceService.getAllPaidInvoices();

    }

        //update payment status by ID
    @RequestMapping(value = "/updatePaymentStatus/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePaymentStatus(@PathVariable("id") String id, @RequestBody String jsonStr) {

        JSONObject jsonObj = new JSONObject(jsonStr);

        String date = jsonObj.getString("date");

        String email = jsonObj.getString("email");

        invoiceService.updatePaymentStatus(id, date);

        mailservice.sendPaymentConfirmationEmail(email, id, date);

    }

    //update invoice
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateInvoice(@RequestBody Invoice invoice){
        invoiceService.updateInvoice(invoice);
    }

    //adding invoice
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addInvoice(@RequestBody Invoice invoice){
        invoiceService.addInvoice(invoice);
    }

}