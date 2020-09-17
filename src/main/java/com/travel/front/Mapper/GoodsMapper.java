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
    public List<Goods> getAllGoods();

    @Select("select * from goods where SSID=#{SSID}")
    public List<Goods> getGoodsBySSID(ScenicSpot scenicSpot);

    @Select("select * from goods where FranID=#{FranID}")
    public List<Goods> getGoodsByFranID(Franchise franchise);

    @Select("select * from goods where LaunchDate=#{LaunchDate}")
    public List<Goods> getGoodsByDate(Date date);

    @Select("select * from goods where GoodsName like '#{name}'")
    public List<Goods> getGoodsByName(String name);

    @Select("select * from goods where Meals=#{Meals}")
    public List<Goods> getGoodsByMeals(boolean Meals);

//    Insert
    @Insert("insert into goods (GoodsName,Price,SSID,Number,FranID,LaunchDate,Ways,Meals)" +
            "values(#{GoodsName},#{Price},#{SSID},#{Number},#{FranID},#{LaunchDate},#{Ways},#{Meals})")
    public Integer CreateGoods(Goods goods);
//    Update
    @Update("UPDATE goods SET GoodsName=#{GoodsName},Price=#{Price},SSID=#{SSID},Number=#{Number},LaunchDate=#{LaunchDate},Ways=#{Ways},Meals=#{Meals}")
    public Integer updateGoods(Goods goods);

//    Delete
    @Delete("delete from goods where GoodsID=#{ID}")
    public Integer deleteGoods(Integer ID);
}
