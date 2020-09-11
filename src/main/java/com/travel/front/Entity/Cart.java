package com.travel.front.Entity;

import java.sql.Date;

public class Cart {
    private int UserID;
    private int GoodsID;
    private int Number;
    private Date AddDate;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(int goodsID) {
        GoodsID = goodsID;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public Date getAddDate() {
        return AddDate;
    }

    public void setAddDate(Date addDate) {
        AddDate = addDate;
    }
}
