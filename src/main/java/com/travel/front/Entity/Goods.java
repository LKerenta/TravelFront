package com.travel.front.Entity;

import java.sql.Date;

public class Goods {
    private Integer GoodsID;
    private String GoodsName;
    private Integer Price;
    private Integer Number;
    private Integer SSID;
    private Integer FranID;
    private Date LaunchDate;
    private String Ways;
    private Integer Meals;
    private Integer State;

    public Integer getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(Integer goodsID) {
        GoodsID = goodsID;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Integer getSSID() {
        return SSID;
    }

    public void setSSID(Integer SSID) {
        this.SSID = SSID;
    }

    public Integer getFranID() {
        return FranID;
    }

    public void setFranID(Integer franID) {
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

    public Integer getMeals() {
        return Meals;
    }

    public void setMeals(Integer meals) {
        Meals = meals;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
