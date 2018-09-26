package com.group25.dao;

import com.group25.entity.SiteManager;
import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
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
            manager.setOrderby(resultSet.getInt("orderby"));
            manager.setManager(resultSet.getInt("manager"));
            manager.setItem(resultSet.getInt("item"));
            manager.setQty(resultSet.getInt("qty"));
            manager.setDate(resultSet.getString("date"));
            manager.setDescription(resultSet.getString("description"));
            manager.setSite(resultSet.getInt("site"));
            manager.setContactnum(resultSet.getInt("contactnum"));
            manager.setRequiredate(resultSet.getString("requiredate"));
            manager.setNote(resultSet.getString("note"));
            manager.setSupplier(resultSet.getInt("supplier"));
            manager.setStatus(resultSet.getString("status"));
            return manager;
        }
    }



    //adding new Request
    public void addRequest(SiteManager manager) {
        String sql = "INSERT INTO orders (orderedby, manager, item, quantity, date, description, site, contactNum, requireDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int orderby = manager.getOrderby();
        int managers = manager.getManager();
        int item = manager.getItem();
        int qty = manager.getQty();
        String date = manager.getDate();
        String description = manager.getDescription();
        int site = manager.getSite();
        int contactnum = manager.getContactnum();
        String requiredate = manager.getRequiredate();
        jdbcTemplate.update(sql, new Object[] {orderby, managers, item, qty, date, description, site, contactnum, requiredate});


    }
}
