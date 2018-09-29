package com.group25.controller;

import com.group25.entity.SiteManager;
import com.group25.service.SiteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/sitemanager")
public class SiteManagerController {

    @Autowired
    private SiteManagerService sitemanagerservice;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<SiteManager> getAllRequest(){
        return sitemanagerservice.getAllRequest();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRequest(@RequestBody SiteManager manager){
        sitemanagerservice.addRequest(manager);
    }

}
