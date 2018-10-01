package com.group25.service;


import com.group25.dao.InvoiceDao;

import com.group25.entity.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceDao invoiceDao;

    public Collection<Invoice> getAllInvoice(){
        return this.invoiceDao.getAllInvoice();
    }

    public Invoice getInvoiceById(int id){
        return this.invoiceDao.getInvoiceById(id);
    }

    public void deleteInvoiceById(int id) {
        this.invoiceDao.deleteInvoiceById(id);
    }

    public void updateInvoice(Invoice invoice){
        this.invoiceDao.updateInvoice(invoice);
    }

    public void addInvoice(Invoice invoice) {
        this.invoiceDao.addInvoice(invoice);
    }

}
