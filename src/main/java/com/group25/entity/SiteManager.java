package com.group25.entity;

import java.sql.Array;

public class SiteManager {
    private int id;
    private int orderBy;
    private int manager;
    private String item;
    private int quantity;
    private String date;
    private String description;
    private String site;
    private int contactNo;
    private String requiredDate;
    private String note;
    private int supplier;
    private String status;
    private String material;
    private String price;
    private int userId;
    private String userName;
    private String mail;
    private String infor;
    private String managerName;
    private String supplierName;
    private  String siteName;


    public SiteManager() {
    }

    public SiteManager(int id, int orderBy, String site, int manager, String date, String requiredDate, String item, int quantity, String description, int contactNo, int supplier, String status, String note) {
        this.id = id;
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
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
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
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
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

    //material
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //price
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //userMail
    public String getPersonMail() {
        return mail;
    }

    public void setPersonMail(String mail) {
        this.mail = mail;
    }

    //mail Content
    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    //Get ManagerName
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    //Get SupplierName
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    //Get SiteName
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
