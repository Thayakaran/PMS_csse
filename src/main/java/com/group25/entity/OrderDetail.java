package com.group25.entity;

import java.util.Date;

public class OrderDetail extends Order {
    private String orderedByName;
    private String managerName;
    private String location;
    private String supplierName;

    public OrderDetail(){
        super();
    }

    public OrderDetail(int id, int orderedBy, String item, Date requestedDate, int manager, String site, double quantity, String description, int contactNo, Date requiredDate, String status, String note, int supplier, String orderedByName, String location, String managerName, String supplierName){
        super(id, orderedBy, item, requestedDate, manager, site, quantity, description, contactNo, requiredDate, status, note, supplier);
        this.orderedByName = orderedByName;
        this.managerName = managerName;
        this.location = location;
        this.supplierName = supplierName;
    }

    public String getOrderedByName() {
        return orderedByName;
    }

    public void setOrderedByName(String orderedByName) {
        this.orderedByName = orderedByName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
