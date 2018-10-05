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

    public Collection<Invoice> getAllInvoices() {

        return this.invoiceDao.getAllInvoices();

    }


    public Invoice getInvoiceById(int invoiceID){
        return this.invoiceDao.getInvoiceById(invoiceID);
    }

    public void deleteInvoiceById(int invoiceID) {
        this.invoiceDao.deleteInvoiceById(invoiceID);
    }

    public void updatePaymentStatus(String id, String date) {

        this.invoiceDao.updateInvoiceStatus(id, date);

    }



    public void updateInvoice(Invoice invoice){
        this.invoiceDao.updateInvoice(invoice);
    }

    public void addInvoice(Invoice invoice) {
        this.invoiceDao.addInvoice(invoice);
    }





}