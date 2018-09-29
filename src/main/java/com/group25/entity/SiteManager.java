package com.group25.entity;

public class SiteManager {

    private int orderBy;
    private int manager;
    private int item;
    private int quantity;
    private String date;
    private String description;
    private int site;
    private int contactNo;
    private String requiredDate;
    private String note;
    private int supplier;
    private String status;


    public SiteManager() {
    }

    public SiteManager(int orderBy, int site, int manager, String date, String requiredDate, int item, int quantity, String description, int contactNo, int supplier, String status, String note) {
        this.orderBy = orderBy;
        this.manager = manager;
        this.item = item;
        this.quantity = quantity;
        this.date = date;
        this.description = description;
        this.site = site;
        this.contactNo = contactNo;
        this.requiredDate = requiredDate;
        this.note = note;
        this.supplier = supplier;
       this.status = status;
    }

    //1 get/set orderby value
    public int getOrderby() {
        return orderBy;
    }

    public void setOrderby(int orderBy) {
        this.orderBy = orderBy;
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
        return quantity;
    }

    public void setQty(int qty) {
        this.quantity = qty;
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
        return contactNo;
    }

    public void setContactnum(int contactnum) {
        this.contactNo = contactnum;
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
        return requiredDate;
    }

    public void setRequiredate(String requiredate) {
        this.requiredDate = requiredate;
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
