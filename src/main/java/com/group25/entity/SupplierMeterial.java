package com.group25.entity;

public class SupplierMeterial {


    private int id;
    private String supplierMaterialType;
    private String measurement;
    private String unitPrice;
    private int supplierID;

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getSupplierMaterialType() {
        return supplierMaterialType;
    }

    public void setSupplierMaterialType(String supplierMaterialType) {
        this.supplierMaterialType = supplierMaterialType;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }



    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }




    public  SupplierMeterial(){}

    public SupplierMeterial(int id, String supplierMaterialType, String measurement, String unitPrice) {
        this.id = id;
        this.supplierMaterialType = supplierMaterialType;
        this.measurement = measurement;
        this.unitPrice = unitPrice;
        this.supplierID = supplierID;

    }



}
