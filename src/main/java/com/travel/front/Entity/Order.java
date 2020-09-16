package com.travel.front.Entity;

public class Order {
    private Integer OrderID;
    private Integer GoodsID;
    private Integer Price;
    private Integer UserID;
    private Integer State;

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
