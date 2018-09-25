package com.group25.dao;

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
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //class for row mapping the user table
    private static class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAddress(resultSet.getString("address"));
            return user;
        }
    }

    //get all users
    public Collection<User> getAllUsers(){
        final String sql = "SELECT id, name, address FROM user";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    //get a specific user
    public User getUserById(int id){
        final String sql = "SELECT id, name, address FROM user WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        return user;
    }

    //delete a specific user
    public void deleteUserById(int id) {
        final String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    //updating existing user
    public void updateUser(User user){
        final String sql = "UPDATE user SET name = ?, address = ? WHERE id = ?";
        int id = user.getId();
        String name = user.getName();
        String address = user.getAddress();
        jdbcTemplate.update(sql, new Object[] {name, address, id});
    }

    //adding new user
    public void addUser(User user) {
        final String sql = "INSERT INTO user (name, address) VALUES (?, ?)";
        String name = user.getName();
        String address = user.getAddress();
        jdbcTemplate.update(sql, new Object[] {name, address});
    }
}
