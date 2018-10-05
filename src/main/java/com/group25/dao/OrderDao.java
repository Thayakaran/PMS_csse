package com.group25.dao;

import com.group25.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            order.setItem(resultSet.getInt("item"));
            order.setQuantity(resultSet.getDouble("quantity"));
            order.setRequestedDate(resultSet.getDate("date"));
            order.setDescription(resultSet.getString("description"));
            order.setSite(resultSet.getInt("site"));
            order.setContactNo(resultSet.getInt("contactNo"));
            order.setRequiredDate(resultSet.getDate("requiredDate"));
            order.setStatus(resultSet.getString("status"));
            order.setNote(resultSet.getString("note"));
            order.setSupplier(resultSet.getInt("supplier"));
            return order;
        }
    }



    public Collection<Order> getPendingOrder(int constructorID){
        String sql = "SELECT * FROM orders WHERE status='pending' AND orderedBy=?";
        List<Order> orders = jdbcTemplate.query(sql, new Object[]{constructorID},new OrderRowMapper());
        return orders;
    }

    public Order getOrderDetails(int orderID){
        String sql = "SELECT * FROM orders WHERE  id=?";
        Order order = jdbcTemplate.queryForObject(sql, new Object[]{orderID},new OrderRowMapper());
        return order;
    }

}