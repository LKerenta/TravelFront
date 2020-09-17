package com.travel.front.Entity;

import java.sql.Date;

public class Goods {
    private int GoodsID;
    private String GoodsName;
    private int Price;
    private int SSID;
    private int Number;
    private int FranID;
    private Date LaunchDate;
    private String Ways;
    private int Meals;

    public int getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(int goodsID) {
        GoodsID = goodsID;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getSSID() {
        return SSID;
    }

    public void setSSID(int SSID) {
        this.SSID = SSID;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getFranID() {
        return FranID;
    }

    public void setFranID(int franID) {
        FranID = franID;
    }

    public Date getLaunchDate() {
        return LaunchDate;
    }

    public void setLaunchDate(Date launchDate) {
        LaunchDate = launchDate;
    }

    public String getWays() {
        return Ways;
    }

    public void setWays(String ways) {
        Ways = ways;
    }

    public int isMeals() {
        return Meals;
    }

    public void setMeals(int meals) {
        Meals = meals;
    }
}
