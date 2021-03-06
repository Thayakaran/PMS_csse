package com.group25.service;

import com.group25.dao.UserDao;
import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers(){
        return this.userDao.getAllUsers();
    }

    public User getUserById(int id){
        return this.userDao.getUserById(id);
    }

    public Collection<User> getUserByRole(String role){
        return this.userDao.getUserByRole(role);
    }

    public String deleteUserById(int id) {
        return this.userDao.deleteUserById(id);
    }

    public String updateUser(User user){
        return this.userDao.updateUser(user);
    }

    public String addUser(User user) {
        return this.userDao.addUser(user);
    }

    public User getUserByEmail(String email){
        return this.userDao.getUserByEmail(email);
    }
}
