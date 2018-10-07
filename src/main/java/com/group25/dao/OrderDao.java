package com.group25.dao;

import com.group25.entity.Order;
import com.group25.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
            jdbcTemplate.update(sql, new Object[]{status, orderID});
            return "{\"success\": \"Successfully Updated\"}";
        }
        else {
            return "{\"error\": \"Invalid Status. Valid Statuses Are : pending, approvedByManager, rejectedByManager, approvedBySupplier, rejectedBySupplier, cancelled, rejectedByConstructor, approvedByConstructor\"}";
        }

    }

}