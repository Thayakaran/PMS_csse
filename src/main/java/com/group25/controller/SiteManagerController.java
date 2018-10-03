package com.group25.controller;

import com.group25.entity.SiteManager;
import com.group25.service.SiteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SiteManager getRequestId(@PathVariable("id") int id){
        return sitemanagerservice.getRequestId(id);
    }

    @RequestMapping(value = "/supplier/{mat}", method = RequestMethod.GET)
    public SiteManager getSupplierId(@PathVariable("mat") String mat){
        return sitemanagerservice.getSupplierId(mat);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRequest(@RequestBody SiteManager manager){
        sitemanagerservice.addRequest(manager);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRequest(@RequestBody SiteManager manager){
        sitemanagerservice.updateRequest(manager);
    }

}
