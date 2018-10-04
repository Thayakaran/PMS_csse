package com.group25.service;
import com.group25.dao.SiteManagerDao;
import com.group25.entity.SiteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SiteManagerService {

    @Autowired
    private SiteManagerDao managerDao;

    public Collection<SiteManager> getAllRequest(){
        return this.managerDao.getAllRequest();
    }
    public Collection<SiteManager> getSupplierId(){
        return this.managerDao.getSupplierId();
    }
    public void addRequest(SiteManager manager) {
        this.managerDao.addRequest(manager);
    }
    public SiteManager getUser(String id){
        return this.managerDao.getUser(id);
    }
    public SiteManager getRequestId(int id){
        return this.managerDao.getRequestId(id);
    }
    public void updateRequest(int id, SiteManager manager){
        this.managerDao.updateRequest(id, manager);
    }
}
