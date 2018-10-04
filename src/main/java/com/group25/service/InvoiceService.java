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

    public void updatePaymentStatus(String id, String date) {

        this.invoiceDao.updateInvoiceStatus(id, date);

    }

}