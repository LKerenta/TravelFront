package com.travel.front.Entity;

public class Order {
    private int OrderID;
    private int GoodsID;
    private int Price;
    private int State;

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
}
