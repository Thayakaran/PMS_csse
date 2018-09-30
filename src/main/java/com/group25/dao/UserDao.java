package com.group25.dao;

import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.awt.peer.SystemTrayPeer;
import java.io.Console;
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

    //get all users
    public Collection<User> getAllUsers(){
        final String sql = "SELECT * FROM user";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    //get a specific user
    public User getUserById(int id){
        final String sql = "SELECT * FROM user WHERE id = ?";
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
        final String sql = "UPDATE user SET fname = ?, lName = ?, mPhone = ?, oPhone = ?, hAddress = ?, wAddress = ?, role = ?, email = ?, password = ? WHERE id = ?";
        int id = user.getId();
        String fName = user.getfName();
        String lName = user.getlName();
        String mPhone = user.getmPhone();
        String oPhone = user.getoPhone();
        String hAddress = user.gethAddress();
        String wAddress = user.getwAddress();
        String role = user.getRole();
        String email = user.getEmail();
        String password = user.getPassword();
        jdbcTemplate.update(sql, new Object[] {fName, lName, mPhone, oPhone, hAddress, wAddress, role, email, password, id});
    }

    //adding new user
    public int addUser(User user) {
        final String sql = "INSERT INTO user (fName, lName, mPhone, oPhone, hAddress, wAddress, role, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String fName = user.getfName();
        String lName = user.getlName();
        String mPhone = user.getmPhone();
        String oPhone = user.getoPhone();
        String hAddress = user.gethAddress();
        String wAddress = user.getwAddress();
        String role = user.getRole();
        String email = user.getEmail();
        String password = user.getPassword();
        int res = jdbcTemplate.update(sql, new Object[] {fName, lName, mPhone, oPhone, hAddress, wAddress, role, email, password});
        return res;
//        System.out.println("resposnessssssssssssssssssssssssss issssssssss : "+res);
    }
}
