package com.group25.dao;

import com.group25.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //class for row mapping the user table
    private static class LoginRowMapper implements RowMapper<Login> {
        @Override
        public Login mapRow(ResultSet resultSet, int i) throws SQLException {

            List loginList = new ArrayList();

            while (resultSet.next()) {
                Login login = new Login();
                login.setPassword(resultSet.getString("password"));
                login.setEmail(resultSet.getString("email"));
                login.setRole(resultSet.getString("role"));
                loginList.add(login);
            }

            Login firstLogin = (Login) loginList.get(0);

            return firstLogin;
        }
    }


    //get user credentials
    public Login getUserLoginCredentials(String email){
        final String sql = "SELECT * FROM user WHERE email = ?";
        Login login = jdbcTemplate.queryForObject(sql, new LoginDao.LoginRowMapper(), email);
        return login;
    }

}
