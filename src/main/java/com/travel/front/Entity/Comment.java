package com.travel.front.Entity;

public class Comment {
    private Integer CID;
    private Integer GoodsID;
    private Integer UserID;
    private String CText;

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public int getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(int goodsID) {
        GoodsID = goodsID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getCText() {
        return CText;
    }

    public void setCText(String CText) {
        this.CText = CText;
    }
}
