package com.travel.front.Entity;

public class Comment {
    private Integer CID;
    private Integer UserID;
    private Integer GoodsID;
    private String CText;

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

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

    public String getCText() {
        return CText;
    }

    public void setCText(String CText) {
        this.CText = CText;
    }
}
