package com.travel.front.Mapper;

import com.travel.front.Entity.ScenicSpot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ScenicSpotMapper {

    @Select("select * from scenicspot where SSName=#{SSName}")
    public List<ScenicSpot> getSSSortedByName(String name);

    @Select("select * from scenicspot where Introduce=#{Introduce} or Introduce like '%,#{Introduce},%'")
    public List<ScenicSpot> getSSSortedByBrief(String keyword);

    @Select("select * from scenicspot where SSID=#{SSID}")
    ScenicSpot getSpotByID(Integer SSID);

    @Select("select * from scenicspot")
    List<ScenicSpot> getAllSpots();
}
