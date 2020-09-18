package com.travel.front.Mapper;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Goods;
import com.travel.front.Entity.ScenicSpot;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface GoodsMapper {
//    SELECT
    @Select("select * from goods")
    List<Goods> getAllGoods();

    @Select("select * from goods where SSID=#{SSID}")
    List<Goods> getGoodsBySSID(ScenicSpot scenicSpot);

    @Select("select * from goods where FranID=#{FranID}")
    List<Goods> getGoodsByFranID(int FranID);

    @Select("select * from goods where LaunchDate=#{LaunchDate}")
    List<Goods> getGoodsByDate(Date date);

    @Select("select * from goods where GoodsName like '#{name}'")
    List<Goods> getGoodsByName(String name);

    @Select("select * from goods where Meals=#{Meals}")
    List<Goods> getGoodsByMeals(int Meals);

//    Insert
    @Insert("insert into goods (GoodsName,Price,SSID,Number,FranID,LaunchDate,Ways,Meals)" +
            "values(#{GoodsName},#{Price},#{SSID},#{Number},#{FranID},#{LaunchDate},#{Ways},#{Meals})")
    Integer CreateGoods(Goods goods);
//    Update
    @Update("UPDATE goods SET GoodsName=#{GoodsName},Price=#{Price},SSID=#{SSID},Number=#{Number},LaunchDate=#{LaunchDate},Ways=#{Ways},Meals=#{Meals}")
    Integer updateGoods(Goods goods);

//    Delete
    @Delete("delete from goods where GoodsID=#{ID}")
    Integer deleteGoods(Integer ID);
}
