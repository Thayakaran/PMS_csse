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
    public Collection<SiteManager> getsiteName(){
        return this.managerDao.getsiteName();
    }

    public String addRequest(SiteManager manager) {
       return this.managerDao.addRequest(manager);

    }
    public Collection<SiteManager> getUser(String id){
        return this.managerDao.getUser(id);
    }
//    public SiteManager getSendMail(String id){
//        return this.managerDao.getSendMail(id);
//    }
    public SiteManager getManagerDetails(String id){
        return this.managerDao.getManagerDetails(id);
    }
    public SiteManager getRequestId(int id){
        return this.managerDao.getRequestId(id);
    }
    public String updateRequest(int id, SiteManager manager){
        return this.managerDao.updateRequest(id, manager);
    }

}
