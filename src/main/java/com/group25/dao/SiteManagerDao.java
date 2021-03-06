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
            manager.setId(resultSet.getInt("id"));
            manager.setOrderby(resultSet.getInt("orderedBy"));
            manager.setManager(resultSet.getInt("manager"));
            manager.setItem(resultSet.getString("item"));
            manager.setQty(resultSet.getInt("quantity"));
            manager.setDate(resultSet.getString("date"));
            manager.setDescription(resultSet.getString("description"));
            manager.setSite(resultSet.getString("site"));
            manager.setContactnum(resultSet.getInt("contactNo"));
            manager.setRequiredate(resultSet.getString("requiredDate"));
            manager.setNote(resultSet.getString("note"));
            manager.setSupplier(resultSet.getInt("supplier"));
            manager.setStatus(resultSet.getString("status"));
            return manager;
        }
    }

    private static class MaterialRowMapper implements RowMapper<SiteManager>{
        @Override
        public SiteManager mapRow(ResultSet resultSet, int i) throws SQLException {
            SiteManager supplier = new SiteManager();
            supplier.setSupplier(resultSet.getInt("s.supplierID"));
            supplier.setMaterial(resultSet.getString("supplierMaterialType"));
            supplier.setPrice(resultSet.getString("unitPrice"));
            supplier.setSupplierName(resultSet.getString("u.fName"));
            supplier.setPersonMail(resultSet.getString("u.email"));
            return supplier;
        }
    }

    private static class userRowMapper implements RowMapper<SiteManager>{
        @Override
        public SiteManager mapRow(ResultSet resultSet, int i) throws SQLException {
            SiteManager user = new SiteManager();
            user.setId(resultSet.getInt("d.id"));
            user.setOrderby(resultSet.getInt("orderedBy"));
            user.setStatus(resultSet.getString("status"));
            user.setRequiredate(resultSet.getString("requiredDate"));
            user.setItem(resultSet.getString("item"));
            return user;
        }
    }

    private static class ManagerRowMapper implements RowMapper<SiteManager>{
        @Override
        public SiteManager mapRow(ResultSet resultSet, int i) throws SQLException {
            SiteManager user = new SiteManager();
            user.setManagerName(resultSet.getString("fname"));
            user.setContactnum(resultSet.getInt("mPhone"));
            user.setUserId(resultSet.getInt("id"));
            return user;
        }
    }

    private static class MailRowMapper implements RowMapper<SiteManager>{
        @Override
        public SiteManager mapRow(ResultSet resultSet, int i) throws SQLException {
            SiteManager mail = new SiteManager();
            mail.setPersonMail(resultSet.getString("email"));
            mail.setManagerName(resultSet.getString("fname"));
            return mail;
        }
    }

    private static class SiteRowMapper implements RowMapper<SiteManager>{
        @Override
        public SiteManager mapRow(ResultSet resultSet, int i) throws SQLException {
            SiteManager mail = new SiteManager();
            mail.setSiteName(resultSet.getString("location"));
            mail.setSite(resultSet.getString("siteID"));
            mail.setId(resultSet.getInt("id"));
            return mail;
        }
    }

    //get all Request
    public List<SiteManager> getAllRequest(){
        final String sql = "SELECT * FROM orders";
        List<SiteManager> manager = jdbcTemplate.query(sql, new SiteManagerDao.SitemanagerRowMapper());
        return manager;
    }

    //get a specific Request
    public SiteManager getRequestId(int id){
        final String sql = "SELECT * FROM orders WHERE id = ?";
        SiteManager request = jdbcTemplate.queryForObject(sql, new SitemanagerRowMapper(), id);
        return request;
    }

    //get a specific manager request
    public  List<SiteManager> getUser(String id){
        final String sql = "SELECT * FROM user u, orders d WHERE d.manager = u.id AND u.email = ?";
        List<SiteManager> user = jdbcTemplate.query(sql, new userRowMapper(), id);
        return user;
    }

    //get a specific manager details
    public  SiteManager getManagerDetails(String id){
        final String sql = "SELECT * FROM user WHERE email = ?";
        SiteManager user = jdbcTemplate.queryForObject(sql, new ManagerRowMapper(), id);
        return user;
    }

    //get mail id
    public SiteManager getSendMail(int id){
        final String sql = "SELECT * FROM user WHERE id = ?";
        SiteManager mail = jdbcTemplate.queryForObject(sql, new MailRowMapper(), id);
        return mail;
    }

//    //get mail id
    public List<SiteManager> getsiteName(){
        final String sql = "SELECT * FROM user u, sites s WHERE u.id = s.manager";
        List<SiteManager> mail = jdbcTemplate.query(sql, new SiteManagerDao.SiteRowMapper());
        return mail;
    }

    //get a specific Supplier id
    public List<SiteManager> getSupplierId(){
        final String sql = "SELECT * FROM supplierMaterials s , user u WHERE s.supplierID = u.id";
        List<SiteManager> supplier = jdbcTemplate.query(sql, new SiteManagerDao.MaterialRowMapper());
        return supplier;
    }


    //adding new Request
    public String addRequest(SiteManager manager) {
        String sql = "INSERT INTO orders (orderedBy, manager, item, quantity, date, description, site, contactNo, requiredDate, status, note, supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int orderBy = manager.getOrderby();
        int managers = manager.getManager();
        String item = manager.getItem();
        int qty = manager.getQty();
        String date = manager.getDate();
        String description = manager.getDescription();
        String site = manager.getSite();
        int contactnum = manager.getContactnum();
        String requiredate = manager.getRequiredate();
        String status = manager.getStatus();
        int supplier = manager.getSupplier();
        String note = manager.getNote();


        try{
            jdbcTemplate.update(sql, new Object[] {orderBy, managers, item, qty, date, description, site, contactnum, requiredate, status, note, supplier});
            return "{\"success\" : true}";
        }
        catch (Exception ex){
            return "{\"success\" : false}";
        }

    }

    //updating existing Request
    public String updateRequest(int id, SiteManager manager){
        final String sql = "UPDATE orders SET status = ?, note = ?, supplier = ? WHERE id = ?";
        String status = manager.getStatus();
        int supplier = manager.getSupplier();
        String note = manager.getNote();


        try{
            jdbcTemplate.update(sql, new Object[] {status, note, supplier, id});
            return "{\"success\" : true}";
        }
        catch (Exception ex){
            return "{\"success\" : false}";
        }
    }
}
