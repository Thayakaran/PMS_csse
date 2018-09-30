package com.group25.entity;

public class Payment {

    private String cardholerName;
    private String cardNo;
    private String expDate;
    private String cvv;
    private String amount;

    public Payment(){}

    public String getCardholerName() {
        return cardholerName;
    }

    public void setCardholerName(String cardholerName) {
        this.cardholerName = cardholerName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
