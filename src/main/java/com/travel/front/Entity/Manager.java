package com.travel.front.Entity;

public class Manager {
    private int MaID;
    private String Password;
    private String MaName;
    private String MaImage;
    private String Phone;
    private String Email;
    private Integer Balance;

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        Balance = balance;
    }

    public int getMaID() {
        return MaID;
    }

    public void setMaID(int maID) {
        MaID = maID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMaName() {
        return MaName;
    }

    public void setMaName(String maName) {
        MaName = maName;
    }

    public String getMaImage() {
        return MaImage;
    }

    public void setMaImage(String maImage) {
        MaImage = maImage;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
