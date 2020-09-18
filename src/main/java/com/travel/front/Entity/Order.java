package com.travel.front.Entity;

import java.sql.Date;

public class Order {
    private Integer OrderID;
    private Integer GoodsID;
    private Integer Price;
    private Integer UserID;
    private Integer State;
    private Integer FranID;
    private Date Date;

    public Integer getFranID() {
        return FranID;
    }

    public void setFranID(Integer franID) {
        FranID = franID;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Integer getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(Integer goodsID) {
        GoodsID = goodsID;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
