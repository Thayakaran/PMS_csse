package com.group25.dao;


import com.group25.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public class InvoiceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class InvoiceRowMapper implements RowMapper<Invoice> {
        @Override
        public Invoice mapRow(ResultSet resultSet, int i) throws SQLException {

            Invoice invoice = new Invoice();

            invoice.setInvoiceID(resultSet.getInt("id"));
            invoice.setOrderID(resultSet.getString("orderId"));
            invoice.setTotalAmount(resultSet.getFloat("totalAmount"));
            invoice.setDiscount(resultSet.getFloat("discount"));
            invoice.setNetAmount(resultSet.getFloat("netAmount"));
            invoice.setPaymentStatus(resultSet.getString("paymentStatus"));
            invoice.setPaidDate(resultSet.getString("paidDate"));
            invoice.setOrderedBy(resultSet.getString("orderedBy"));
            invoice.setItem(resultSet.getString("item"));
            invoice.setQuantity(resultSet.getInt("quantity"));
            invoice.setDate(resultSet.getString("date"));
            invoice.setSupplier(resultSet.getString("supplier"));
            invoice.setContactNo(resultSet.getString("contactNo"));

            return invoice;

        }
    }

    public Collection<Invoice> getAllInvoices(){
        final String sql = "SELECT * FROM invoice i, orders o where i.orderId = o.id";
        List<Invoice> invoices = jdbcTemplate.query(sql, new InvoiceDao.InvoiceRowMapper());
        return invoices;
    }

    public void updateInvoiceStatus(String id, String date) {

        final String sql = "UPDATE invoice  SET paymentStatus = \"Paid\", paidDate = ? WHERE id = ?";

        jdbcTemplate.update(sql, date, id);

    }


    //get a specific invoice
    public Invoice getInvoiceById(int invoiceID){
        final String sql = "SELECT * FROM invoice WHERE id = ?";
        Invoice invoice = jdbcTemplate.queryForObject(sql, new InvoiceRowMapper(), invoiceID);
        return invoice;
    }




    //delete a specific invoice
    public void deleteInvoiceById(int invoiceID) {
        final String sql = "DELETE FROM invoice WHERE id = ?";
        jdbcTemplate.update(sql, invoiceID);
    }

    //updating existing invoice
    public void updateInvoice(Invoice invoice){
        final String sql = "UPDATE invoice SET orderID = ?, totalAmount = ?, discount = ?, netAmount = ? WHERE id = ?";
        int invoiceID = invoice.getInvoiceID();
        String oredrId = invoice.getOrderID();
        float totalAmount = invoice.getTotalAmount();
        float discount = invoice.getDiscount();
        float netAmount = invoice.getNetAmount();

        jdbcTemplate.update(sql, new Object[] {oredrId, totalAmount, discount, netAmount});



    }

    //updating existing invoice
    public void addInvoice(Invoice invoice){
        final String sql = "INSERT INTO invoice(orderID, totalAmount, discount, netAmount) VALUES (?,?,?,?)";

       String orderID = invoice.getOrderID();
        float totalAmount = invoice.getTotalAmount();
        float discount = invoice.getDiscount();
        float netAmount = invoice.getNetAmount();

        jdbcTemplate.update(sql, new Object[] {orderID, totalAmount, discount, netAmount});



    }

}
