package com.group25.service;

import com.group25.dao.SiteManagerDao;
import com.group25.dao.UserDao;
import com.group25.entity.SiteManager;
import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SiteManagerService {

    @Autowired
    private SiteManagerDao managerDao;

    public Collection<SiteManager> getAllRequest(){
        return this.managerDao.getAllRequest();}

    public void addRequest(SiteManager manager) {
        this.managerDao.addRequest(manager);
    }
}
