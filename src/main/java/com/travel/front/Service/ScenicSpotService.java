package com.travel.front.Service;

import com.travel.front.Entity.ScenicSpot;

import java.util.List;


public interface ScenicSpotService {
    List<ScenicSpot> SearchByName(String name);
    List<ScenicSpot> SearchByBrief(String brief);
    ScenicSpot getSpotByID(Integer SSID);
    List<ScenicSpot> getAllSpot();
}
