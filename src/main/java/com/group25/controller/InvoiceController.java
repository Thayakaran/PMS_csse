package com.group25.controller;

import com.group25.entity.Invoice;

import com.group25.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Invoice> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable("id") int id){
        return invoiceService.getInvoiceById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteInvoiceById(@PathVariable("id") int id){
        invoiceService.deleteInvoiceById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateInvoice(@RequestBody Invoice invoice){
        invoiceService.updateInvoice(invoice);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addInvoice(@RequestBody Invoice invoice){
        invoiceService.addInvoice(invoice);
    }

}
