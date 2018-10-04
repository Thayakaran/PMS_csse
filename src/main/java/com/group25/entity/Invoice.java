package com.group25.entity;

public class Invoice {

    private int id;
    private String orderId;
//    private String description;
//    private String qty;
//    private String deliveredDate;
    private float totalAmount;
    private float discount;
    private float netAmount;



    public  Invoice(){}

    public Invoice(int id, String orderId, float totalAmount, float discount, float netAmount) {
        this.id = id;
        this.orderId = orderId;
//        this.description = description;
//        this.qty = qty;
//        this.deliveredDate = deliveredDate;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.netAmount = netAmount;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getorderId() {
        return orderId;
    }

    public void setoredrId(String orderId) {
        this.orderId = orderId;
    }

    public float getnetAmount() {
        return netAmount;
    }

    public void setnetAmount(float netAmount) {
        this.netAmount = netAmount;
    }

    public float gettotalAmount() {
        return totalAmount;
    }

    public void settotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getdiscount() {
        return discount;
    }

    public void setdiscount(float discount) {
        this.discount = discount;
    }


}
