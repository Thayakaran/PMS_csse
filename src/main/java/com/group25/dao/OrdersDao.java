package com.group25.dao;

import com.group25.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class OrdersDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class OrdersRowMapper implements RowMapper<Orders>{
        @Override
        public Orders mapRow(ResultSet resultSet, int i) throws SQLException {
            Orders order = new Orders();
            order.setId(resultSet.getInt("id"));
            order.setContactNo(resultSet.getInt("contactNo"));
            order.setDescription(resultSet.getString("description"));
            order.setItem(resultSet.getInt("item"));
            order.setManager(resultSet.getInt("manager"));
            order.setOrderedBy(resultSet.getInt("orderedBy"));
            order.setQuantity(resultSet.getDouble("quantity"));
            order.setRequestedDate(resultSet.getDate("date"));
            order.setRequiredDate(resultSet.getDate("requiredDate"));
            order.setSite(resultSet.getInt("site"));
            return order;
        }

        public Collection<Orders> get

    }

}