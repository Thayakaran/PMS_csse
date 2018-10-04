package com.group25.controller;


import com.group25.entity.Invoice;
import com.group25.service.InvoiceService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Invoice> getAllInvoices(){

        return invoiceService.getAllInvoices();

    }

    @RequestMapping(value = "/updatePaymentStatus/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePaymentStatus(@PathVariable("id") String id, @RequestBody String jsonStr) {

        JSONObject jsonObj = new JSONObject(jsonStr);

        String date = jsonObj.getString("date");

        invoiceService.updatePaymentStatus(id, date);

    }

}