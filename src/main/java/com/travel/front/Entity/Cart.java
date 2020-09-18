package com.travel.front.Entity;

import java.sql.Date;

public class Cart {
    private Integer UserID;
    private Integer GoodsID;
    private Integer Number;
    private Date AddDate;

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(Integer goodsID) {
        GoodsID = goodsID;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Date getAddDate() {
        return AddDate;
    }

    public void setAddDate(Date addDate) {
        AddDate = addDate;
    }
}
