package com.group25.entity;

public class SiteManager {

    private int orderby;
    private int manager;
    private int item;
    private int qty;
    private String date;
    private String description;
    private int site;
    private int contactnum;
    private String requiredate;
    private String note;
    private int supplier;
    private String status;


    public SiteManager() {
    }

    public SiteManager(int orderby, int manager, int item, int qty, String date, String description, int site, int contactnum, String requiredate, String note, int supplier, String status) {
        this.orderby = orderby;
        this.manager = manager;
        this.item = item;
        this.qty = qty;
        this.date = date;
        this.description = description;
        this.site = site;
        this.contactnum = contactnum;
        this.requiredate = requiredate;
        this.note = note;
        this.supplier = supplier;
        this.status = status;
    }

    //1 get/set orderby value
    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

    //2 get/set manager value
    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    //3 get/set item value
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    //4 get/set qty value
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    //5 get/set site value
    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    //6 get/set contact number value
    public int getContactnum() {
        return contactnum;
    }

    public void setContactnum(int contactnum) {
        this.contactnum = contactnum;
    }

    //7 get/set date value
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //8 get/set description value
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //9 get/set requiredate value
    public String getRequiredate() {
        return requiredate;
    }

    public void setRequiredate(String requiredate) {
        this.requiredate = requiredate;
    }

    //10 get/set Note value
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //11 get/set Status value
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //12 get/set supplier value
    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }
}
