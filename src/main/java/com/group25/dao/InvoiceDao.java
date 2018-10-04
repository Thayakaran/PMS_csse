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

    private static class InvoiceRowMapper implements RowMapper<Invoice>{
        @Override
        public Invoice mapRow(ResultSet resultSet , int i) throws SQLException{
            Invoice invoice = new Invoice();
            invoice.setId(resultSet.getInt("id"));
            invoice.setoredrId(resultSet.getString("orderID"));
            invoice.settotalAmount(resultSet.getFloat("totalAmount"));
            invoice.setdiscount(resultSet.getFloat("discount"));
            invoice.setnetAmount(resultSet.getFloat("netAmount"));
            return invoice;
        }
    }

    //get all invoice

    public Collection<Invoice> getAllInvoice(){
        final String sql = "SELECT * FROM invoice";
        List<Invoice> invoices = jdbcTemplate.query(sql , new InvoiceRowMapper());
        return invoices;
    }

    //get a specific invoice
    public Invoice getInvoiceById(int id){
        final String sql = "SELECT * FROM invoice WHERE id = ?";
        Invoice invoice = jdbcTemplate.queryForObject(sql, new InvoiceRowMapper(), id);
        return invoice;
    }

    //delete a specific invoice
    public void deleteInvoiceById(int id) {
        final String sql = "DELETE FROM invoice WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    //updating existing invoice
    public void updateInvoice(Invoice invoice){
        final String sql = "UPDATE invoice SET orderID = ?, totalAmount = ?, discount = ?, netAmount = ? WHERE id = ?";
        int id = invoice.getId();
        String oredrId = invoice.getorderID();
        float totalAmount = invoice.gettotalAmount();
        float discount = invoice.getdiscount();
        float netAmount = invoice.getnetAmount();

        jdbcTemplate.update(sql, new Object[] {oredrId, totalAmount, discount, netAmount, id});



    }

    //updating existing invoice
    public void addInvoice(Invoice invoice){
        final String sql = "INSERT INTO invoice(orderID, totalAmount, discount, netAmount) VALUES (?,?,?,?)";
//        int id = invoice.getId();
       String orderID = invoice.getorderID();
        float totalAmount = invoice.gettotalAmount();
        float discount = invoice.getdiscount();
        float netAmount = invoice.getnetAmount();

        jdbcTemplate.update(sql, new Object[] {orderID, totalAmount, discount, netAmount});



    }

}
