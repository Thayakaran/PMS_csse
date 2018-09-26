package com.group25.entity;

public class User {

    private int id;
    private String fName;
    private String lName;
    private String mPhone;
    private String oPhone;
    private String hAddress;
    private String wAddress;
    private String role;
    private String email;
    private String password;

    public  User(){}

    public User(int id, String fName, String lName, String mPhone, String oPhone, String hAddress, String wAddress, String role, String email, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mPhone = mPhone;
        this.oPhone = oPhone;
        this.hAddress = hAddress;
        this.wAddress = wAddress;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public String getwAddress() {
        return wAddress;
    }

    public void setwAddress(String wAddress) {
        this.wAddress = wAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
