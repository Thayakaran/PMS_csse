package com.group25.controller;

import com.group25.entity.Invoice;
import com.group25.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/updatePaymentStatus/{id}", method = RequestMethod.PUT)
    public void updatePaymentStatus(@PathVariable("id") String id) {

        invoiceService.updatePaymentStatus(id);

    }

}