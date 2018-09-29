package com.group25.dao;

import com.group25.entity.SiteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SiteManagerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //class for row mapping the orders table
    private static class SitemanagerRowMapper implements RowMapper<SiteManager>{
        @Override
        public SiteManager mapRow(ResultSet resultSet, int i) throws SQLException {
            SiteManager manager = new SiteManager();
            manager.setOrderby(resultSet.getInt("orderedBy"));
            manager.setManager(resultSet.getInt("manager"));
            manager.setItem(resultSet.getInt("item"));
            manager.setQty(resultSet.getInt("quantity"));
            manager.setDate(resultSet.getString("date"));
            manager.setDescription(resultSet.getString("description"));
            manager.setSite(resultSet.getInt("site"));
            manager.setContactnum(resultSet.getInt("contactNo"));
            manager.setRequiredate(resultSet.getString("requiredDate"));
            manager.setNote(resultSet.getString("note"));
            manager.setSupplier(resultSet.getInt("supplier"));
            manager.setStatus(resultSet.getString("status"));
            return manager;
        }
    }

    //get all users
    public List<SiteManager> getAllRequest(){
        final String sql = "SELECT * FROM orders";
        List<SiteManager> manager = jdbcTemplate.query(sql, new SiteManagerDao.SitemanagerRowMapper());
        return manager;
    }



    //adding new Request
    public void addRequest(SiteManager manager) {
        String sql = "INSERT INTO orders (orderedBy, manager, item, quantity, date, description, site, contactNo, requiredDate, status, note, supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int orderBy = manager.getOrderby();
        int managers = manager.getManager();
        int item = manager.getItem();
        int qty = manager.getQty();
        String date = manager.getDate();
        String description = manager.getDescription();
        int site = manager.getSite();
        int contactnum = manager.getContactnum();
        String requiredate = manager.getRequiredate();
        String status = manager.getStatus();
        int supplier = manager.getSupplier();
        String note = manager.getNote();
        jdbcTemplate.update(sql, new Object[] {orderBy, managers, item, qty, date, description, site, contactnum, requiredate, status, note, supplier});


    }
}
