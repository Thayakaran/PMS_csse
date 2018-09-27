package com.group25.entity;

import java.util.Date;

public class Orders {
    private int id;
    private int orderedBy;
    private int item;
    private Date requestedDate;
    private int manager;
    private int site;
    private double quantity;
    private String description;
    private int contactNo;
    private Date requiredDate;

    public Orders(){}

    public Orders(int id, int orderedBy, int item, Date requestedDate, int manager, int site, double quantity, String description, int contactNo, Date requiredDate) {
        this.id = id;
        this.orderedBy = orderedBy;
        this.item = item;
        this.requestedDate = requestedDate;
        this.manager = manager;
        this.site = site;
        this.quantity = quantity;
        this.description = description;
        this.contactNo = contactNo;
        this.requiredDate = requiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(int orderedBy) {
        this.orderedBy = orderedBy;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }
}
