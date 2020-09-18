package com.travel.front.Entity;

import java.sql.Date;

public class Order {
    private int OrderID;
    private int GoodsID;
    private int Price;
    private int UserID;
    private int State;
    private int FranID;
    private Date date;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(int goodsID) {
        GoodsID = goodsID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public int getFranID() {
        return FranID;
    }

    public void setFranID(int franID) {
        FranID = franID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
