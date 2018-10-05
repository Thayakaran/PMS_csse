package com.group25.service;

import com.group25.dao.SiteDao;
import com.group25.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SiteService {
    @Autowired
    private SiteDao siteDao;

    public Collection<Site> getAllSites(){
        return this.siteDao.getAllSites();
    }

    public Site getSiteById(String siteID){
        return this.siteDao.getSiteById(siteID);
    }

    public String deleteSiteById(String siteID) {
        return this.siteDao.deleteSiteById(siteID);
    }

    public String updateSite(Site site){
        return this.siteDao.updateSite(site);
    }

    public String addSite(Site site) {
        return this.siteDao.addSite(site);
    }
}
