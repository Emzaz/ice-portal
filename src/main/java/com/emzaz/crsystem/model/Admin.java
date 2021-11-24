package com.emzaz.crsystem.model;

public class Admin {

    private String adminId;
    private String userName;
    private String email;
    private String password;

    public Admin() {
    }

    public Admin(String adminId, String userName, String email, String password) {
        this.adminId = adminId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
