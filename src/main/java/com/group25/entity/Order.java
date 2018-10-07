package com.group25.entity;

import java.util.Date;

public class Order {

    protected int id;
    protected int orderedBy;
    protected int manager;
    protected String item;
    protected double quantity;
    protected Date requestedDate;
    protected String description;
    protected String site;
    protected int contactNo;
    protected Date requiredDate;
    protected String status;
    protected String note;
    protected int supplier;

    public Order(){}

    public Order(int id, int orderedBy, String item, Date requestedDate, int manager, String site, double quantity, String description, int contactNo, Date requiredDate, String status, String note, int supplier) {
        this.id = id;
        this.orderedBy = orderedBy;
        this.manager = manager;
        this.item = item;
        this.quantity = quantity;
        this.requestedDate = requestedDate;
        this.description = description;
        this.site = site;
        this.contactNo = contactNo;
        this.requiredDate = requiredDate;
        this.status = status;
        this.note = note;
        this.supplier = supplier;
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

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }
}