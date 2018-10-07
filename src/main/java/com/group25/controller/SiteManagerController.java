package com.group25.controller;

import com.group25.entity.SiteManager;
import com.group25.mailService.MailService;
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

    @Autowired
    MailService mailservice;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<SiteManager> getAllRequest(){
        return sitemanagerservice.getAllRequest();
    }
    @RequestMapping(value = "/supplier", method = RequestMethod.GET)
    public Collection<SiteManager> getSupplierId(){
        return sitemanagerservice.getSupplierId();
    }

    @RequestMapping(value = "/site", method = RequestMethod.GET)
    public Collection<SiteManager> getsiteName(){
        return sitemanagerservice.getsiteName();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SiteManager getRequestId(@PathVariable("id") int id){
        return sitemanagerservice.getRequestId(id);
    }

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
    public SiteManager getManagerDetails(@PathVariable("id") String id){
        return sitemanagerservice.getManagerDetails(id);
    }


    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public Collection<SiteManager> getUser(@PathVariable("id") String id){
        return sitemanagerservice.getUser(id);
    }

//    //@RequestMapping(value = "mail/{id}", method = RequestMethod.GET)
//    //public SiteManager getSendMail(@PathVariable("id") String id){
//        return sitemanagerservice.getSendMail(id);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRequest(@RequestBody SiteManager manager){
         sitemanagerservice.addRequest(manager);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRequest(@PathVariable("id") int id, @RequestBody SiteManager manager){
        sitemanagerservice.updateRequest(id ,manager);
        mailservice.sendApprovemail(manager);
    }

}
