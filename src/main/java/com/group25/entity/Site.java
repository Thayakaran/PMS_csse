package com.group25.entity;

public class Site {

    private String siteID;
    private String location;
    private String client;
    private String manager;
    private String contractors;
    private String suppliers;

    public Site() {}

    public Site(String siteID, String location, String client, String manager, String contractors, String suppliers) {
        this.siteID = siteID;
        this.location = location;
        this.client = client;
        this.manager = manager;
        this.contractors = contractors;
        this.suppliers = suppliers;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContractors() {
        return contractors;
    }

    public void setContractors(String contractors) {
        this.contractors = contractors;
    }

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers;
    }
}
