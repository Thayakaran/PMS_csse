package com.group25.controller;

import com.group25.entity.Site;
import com.group25.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sites")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Site> getAllSites(){
        return siteService.getAllSites();
    }

    @RequestMapping(value = "/{siteID}", method = RequestMethod.GET)
    public Site getSiteById(@PathVariable("siteID") String siteID){
        return siteService.getSiteById(siteID);
    }

    @RequestMapping(value = "/{siteID}", method = RequestMethod.DELETE)
    public String deleteSiteById(@PathVariable("siteID") String siteID){
        return siteService.deleteSiteById(siteID);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateSite(@RequestBody Site site){
        return siteService.updateSite(site);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addSite(@RequestBody Site site){
        return siteService.addSite(site);
    }
}
