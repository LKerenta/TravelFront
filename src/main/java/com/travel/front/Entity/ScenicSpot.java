package com.travel.front.Entity;

public class ScenicSpot {
    private int SSID;
    private String SSName;
    private String SSImage_1;
    private String SSImage_2;
    private String SSImage_3;
    private String Introduce;

    public int getSSID() {
        return SSID;
    }

    public void setSSID(int SSID) {
        this.SSID = SSID;
    }

    public String getSSName() {
        return SSName;
    }

    public void setSSName(String SSName) {
        this.SSName = SSName;
    }

    public String getSSImage_1() {
        return SSImage_1;
    }

    public void setSSImage_1(String SSImage_1) {
        this.SSImage_1 = SSImage_1;
    }

    public String getSSImage_2() {
        return SSImage_2;
    }

    public void setSSImage_2(String SSImage_2) {
        this.SSImage_2 = SSImage_2;
    }

    public String getSSImage_3() {
        return SSImage_3;
    }

    public void setSSImage_3(String SSImage_3) {
        this.SSImage_3 = SSImage_3;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }
}
