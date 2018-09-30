package com.group25.service;

import com.group25.dao.LoginDao;
import com.group25.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public Login getUserCredentials(String email){

        return this.loginDao.getUserLoginCredentials(email);

    }

}
