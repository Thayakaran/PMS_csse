package com.group25.dao;

import com.group25.entity.Order;
import com.group25.entity.OrderDetail;
import com.group25.entity.Site;
import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class OrderRowMapper implements RowMapper<Order>{
        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setOrderedBy(resultSet.getInt("orderedBy"));
            order.setManager(resultSet.getInt("manager"));
            order.setItem(resultSet.getString("item"));
            order.setQuantity(resultSet.getDouble("quantity"));
            order.setRequestedDate(resultSet.getDate("date"));
            order.setDescription(resultSet.getString("description"));
            order.setSite(resultSet.getString("site"));
            order.setContactNo(resultSet.getInt("contactNo"));
            order.setRequiredDate(resultSet.getDate("requiredDate"));
            order.setStatus(resultSet.getString("status"));
            order.setNote(resultSet.getString("note"));
            order.setSupplier(resultSet.getInt("supplier"));
            return order;
        }
    }
    private static class OrderDetailsRowMapper implements RowMapper<OrderDetail>{
        @Override
        public OrderDetail mapRow(ResultSet resultSet, int i) throws SQLException {
            OrderDetail order = new OrderDetail();
            order.setId(resultSet.getInt("id"));
            order.setOrderedBy(resultSet.getInt("orderedBy"));
            order.setManager(resultSet.getInt("manager"));
            order.setItem(resultSet.getString("item"));
            order.setQuantity(resultSet.getDouble("quantity"));
            order.setRequestedDate(resultSet.getDate("date"));
            order.setDescription(resultSet.getString("description"));
            order.setSite(resultSet.getString("site"));
            order.setContactNo(resultSet.getInt("contactNo"));
            order.setRequiredDate(resultSet.getDate("requiredDate"));
            order.setStatus(resultSet.getString("status"));
            order.setNote(resultSet.getString("note"));
            order.setSupplier(resultSet.getInt("supplier"));

            order.setOrderedByName(resultSet.getString("orderedByName"));
            order.setManagerName(resultSet.getString("managerName"));
            order.setLocation(resultSet.getString("siteLocation"));
            order.setLocation(resultSet.getString("siteLocation"));
            return order;
        }
    }
    private static class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setfName(resultSet.getString("fName"));
            user.setlName(resultSet.getString("lName"));
            user.setmPhone(resultSet.getString("mPhone"));
            user.setoPhone(resultSet.getString("oPhone"));
            user.sethAddress(resultSet.getString("hAddress"));
            user.setwAddress(resultSet.getString("wAddress"));
            user.setRole(resultSet.getString("role"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
    private static class SiteRowMapper implements RowMapper<Site> {
        @Override
        public Site mapRow(ResultSet resultSet, int i) throws SQLException {
            Site site = new Site();
            site.setSiteID(resultSet.getString("SiteID"));
            site.setLocation(resultSet.getString("Location"));
            site.setClient(resultSet.getString("Client"));
            site.setManager(resultSet.getInt("Manager"));
            site.setContractors(resultSet.getString("Contractors"));
            site.setSuppliers(resultSet.getString("Suppliers"));
            return site;
        }
    }

    //This will return the order dtails object as collection
    public Collection<OrderDetail> getOrderDetails(String constructorID, String managerID, String supplierID, String status, String from, String to){
        boolean and = false;
        List<String> param = new ArrayList();
        String sql = "SELECT o.id, o.orderedBy orderedBy, u2.fName orderedByName, o.manager manager, u1.fName managerName, o.item item, " +
                "o.quantity quantity, o.date date, o.description description, o.site site, s.location siteLocation, o.contactNo contactNo,\n" +
                "o.requiredDate, o.status, o.note, o.supplier, u3.fName supplierName\n" +
                "FROM orders o\n" +
                "LEFT JOIN user u1\n" +
                "ON o.manager = u1.id\n" +
                "LEFT JOIN user u2\n" +
                "ON o.orderedBy = u2.id\n" +
                "LEFT JOIN user u3\n" +
                "ON o.supplier = u3.id\n" +
                "LEFT JOIN sites s\n" +
                "ON o.site = s.siteID";
        if(constructorID.equals("0") && managerID.equals("0") && supplierID.equals("0") && status.equals("0") && from.equals("0") && to.equals("0")){
            sql = sql;
        }
        else{
            sql = sql + " WHERE ";
        }

        if (!constructorID.equals("0")){
            param.add(constructorID);
            sql = sql + "o.orderedBY = ? ";
            and = true;
        }
        if (!managerID.equals("0")){
            param.add(managerID);
            if (and){
                sql = sql + " AND o.manager = ?";
            }
            else{
                sql = sql + " o.manager = ?";
                and = true;
            }
        }
        if (!supplierID.equals("0")){
            param.add(supplierID);
            if (and){
                sql = sql + " AND o.supplier = ?";
            }
            else{
                sql = sql + " o.supplier = ?";
                and = true;
            }
        }
        if (!status.equals("0")){
            param.add(status);
            if (and){
                sql = sql + " AND o.status = ?";
            }
            else{
                sql = sql + " o.status = ?";
                and = true;
            }
        }
        if (!from.equals("0") && !from.equals("0")){
            param.add(from);
            param.add(to);
            if (and){
                sql = sql + " AND o.date BETWEEN  ? AND ?";
            }
            else{
                sql = sql + " o.date BETWEEN  ? AND ?";
            }
        }
        List<OrderDetail> orders = jdbcTemplate.query(sql, param.toArray(),new OrderDetailsRowMapper());
        return orders;
    }

    public String updateOrderStatus(String orderID, String status){
        if (status.equals("pending") || status.equals("approvedByManager") || status.equals("rejectedByManager") || status.equals("approvedBySupplier") || status.equals("rejectedBySupplier") || status.equals("cancelled") || status.equals("rejectedByConstructor") || status.equals("approvedByConstructor")){
            String sql = "UPDATE orders SET status = ? WHERE id = ?";
            try{
                jdbcTemplate.update(sql, new Object[]{status, orderID});
                return "{\"success\": \"Successfully Updated\"}";
            }
            catch (Exception ex){
                return "{\"error\": \""+ex.toString()+"\"}";
            }

        }
        else {
            return "{\"error\": \"Invalid Status. Valid Statuses Are : pending, approvedByManager, rejectedByManager, approvedBySupplier, rejectedBySupplier, cancelled, rejectedByConstructor, approvedByConstructor\"}";
        }
    }
    public String addOrder(int orderedBy, String item, int manager, String site, double quantity, String description, int contactNo, Date requiredDate, String note){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String status = "pending";
        String requestedDate = dateFormat.format(new Date());
        String sql = "INSERT INTO orders(orderedBy, manager, item, quantity, date, description, site, contactNo, requiredDate, status, note) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql, new Object[]{orderedBy, manager,item, quantity, requestedDate, description, site, contactNo, requiredDate, status, note});
            return "{\"success\": \"Successfully Added\"}";
        }
        catch (Exception ex){
            return "{\"error\": \""+ex.toString()+"\"}";
        }
    }
    public String updateOrder(int orderID, int orderedBy, String item, int manager, String site, double quantity, String description, int contactNo, Date requiredDate, String note){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String requestedDate = dateFormat.format(new Date());
        String sql = "UPDATE orders SET orderedBy = ? , manager = ?, item = ?, quantity = ?, date = ?, description = ?, site = ?, contactNo = ?, requiredDate = ?, note = ? WHERE id = ?";
        try{
            jdbcTemplate.update(sql, new Object[]{orderedBy, manager, item.toLowerCase(), quantity, requestedDate, description, site, contactNo, requiredDate, note, orderID});
            return "{\"success\": \"Successfully Updated\"}";
        }
        catch (Exception ex){
            return "{\"error\": \""+ex.toString()+"\"}";
        }
    }
    public Collection<String> getMaterials(){
        List<String> data = jdbcTemplate.queryForList("SELECT DISTINCT supplierMaterialType  FROM supplierMaterials",String.class);
        return data;
    }
    public Collection<User> getManagers(){
        List<User> data = jdbcTemplate.query("SELECT * FROM user WHERE role = 'Site Manager'", new UserRowMapper());
        return data;
    }
    public Collection<Site> getSites(){
        List<Site> data = jdbcTemplate.query("SELECT * FROM sites", new SiteRowMapper());
        return data;
    }
}
