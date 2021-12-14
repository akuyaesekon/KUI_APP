package com.example.kuiapp;

public class User {
    private String username;
    private String regNo;
    private String phoneNo;
    private String email;

    public User(){

    }

    public User(String username, String regNo, String phoneNo, String email) {
        this.username = username;
        this.regNo = regNo;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
