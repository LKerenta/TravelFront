package com.travel.front.Service;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Goods;
import com.travel.front.Entity.ScenicSpot;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;

public interface GoodsService {
    PageInfo<Goods> getAllGoods(Integer PageSize,Integer PageIndex);
    PageInfo<Goods> getGoodsByGoodName(Integer PageSize,Integer PageIndex,String GoodName);
    PageInfo<Goods> getGoodsByGoodID(Integer PageSize,Integer PageIndex,Integer GoodID);
    PageInfo<Goods> getGoodsByPrice(Integer PageSize,Integer PageIndex,Integer Price);
    PageInfo<Goods> getGoodsByFranName(Integer PageSize,Integer PageIndex,String FranName);
    PageInfo<Goods> getGoodsByFranNameAndGoodsName(Integer PageSize,Integer PageIndex,String GoodsName,String FranName);
    PageInfo<Goods> getAllGoodsByPriceAndGoodsName(Integer PageSize,Integer PageIndex,String GoodsName,Integer Price);
    PageInfo<Goods> getAllGoodsByPriceAndFranName(Integer PageSize,Integer PageIndex,String FranName,Integer Price);
    PageInfo<Goods> getAllGoodsByGoodsIDAndFranName(Integer PageSize,Integer PageIndex,String FranName,Integer GoodsID);
    PageInfo<Goods> getAllGoodsByGoodsIDAndGoodsName(Integer PageSize,Integer PageIndex,String GoodsName,Integer GoodsID);
    PageInfo<Goods> getAllGoodsByGoodsIDAndPrice(Integer PageSize,Integer PageIndex,Integer Price,Integer GoodsID);
    PageInfo<Goods> getAllGoodsByGoodsNameAndFranNameAndPrice(Integer PageSize,Integer PageIndex,Integer Price,String GoodsName,String FranName);
    PageInfo<Goods> getAllGoodsByGoodsIDAndFranNameAndPrice(Integer PageSize,Integer PageIndex,Integer Price,Integer GoodsID,String FranName);
    PageInfo<Goods> getAllGoodsByGoodsNameAndFranNameAndGoodsID(Integer PageSize,Integer PageIndex,Integer GoodsID,String GoodsName,String FranName);
    PageInfo<Goods> getAllGoodsByGoodsNameAndGoodsIDAndPrice(Integer PageSize,Integer PageIndex,Integer Price,String GoodsName,Integer GoodsID);
    PageInfo<Goods> getAllGoodsByGoodsNameAndGoodsIDAndPriceAndFranName(Integer PageSize,Integer PageIndex,String FranName,Integer Price,String GoodsName,Integer GoodsID);

    List<String> getAllFranName();
    List<String> getAllFranNameByGoodName(String GoodName);
    List<String> getAllFranNameByGoodID(Integer GoodID);
    List<String> getAllFranNameByPrice(Integer Price);
    List<String> getAllFranNameByFranName(String FranName);
    List<String> getAllFranNameByFranNameAndGoodsName(String GoodsName,String FranName);
    List<String> getAllFranNameByPriceAndGoodsName(String GoodsName,Integer Price);
    List<String> getAllFranNameByPriceAndFranName(String FranName,Integer Price);
    List<String> getAllFranNameByGoodsIDAndFranName(String FranName,Integer GoodsID);
    List<String> getAllFranNameByGoodsIDAndGoodsName(String GoodsName,Integer GoodsID);
    List<String> getAllFranNameByGoodsIDAndPrice(Integer Price,Integer GoodsID);
    List<String> getAllFranNameByGoodsNameAndFranNameAndPrice(Integer Price,String GoodsName,String FranName);
    List<String> getAllFranNameByGoodsIDAndFranNameAndPrice(Integer Price,Integer GoodsID,String FranName);
    List<String> getAllFranNameByGoodsNameAndFranNameAndGoodsID(Integer GoodsID,String GoodsName,String FranName);
    List<String> getAllFranNameByGoodsNameAndGoodsIDAndPrice(Integer Price,String GoodsName,Integer GoodsID);
    List<String> getAllFranNameByGoodsNameAndGoodsIDAndPriceAndFranName(String FranName,Integer Price,String GoodsName,Integer GoodsID);

    Integer deleteGoodsByGoodsID(Integer GoodsID);

    PageInfo<Goods> getAllExamineGoods(Integer PageSize,Integer PageIndex);
    PageInfo<Goods> getAllExamineGoodsWithOutGoodsIDAndPrice(Integer PageSize,Integer PageIndex,String GoodsName,String FranName);
    PageInfo<Goods> getAllExamineGoodsByGoodsID(Integer PageSize,Integer PageIndex,String GoodsName,String FranName,Integer GoodsID);
    PageInfo<Goods> getAllExamineGoodsByPrice(Integer PageSize,Integer PageIndex,String GoodsName,String FranName,Integer Price);
    PageInfo<Goods> getAllExamineGoodsByPriceAndGoodsID(Integer PageSize,Integer PageIndex,Integer GoodsID,String GoodsName,String FranName,Integer Price);

    List<String> getAllExamineFranName();
    List<String> getAllExamineFranNameWithOutGoodsIDAndPrice(String GoodsName,String FranName);
    List<String> getAllExamineFranNameByGoodsID(String GoodsName,String FranName,Integer GoodsID);
    List<String> getAllExamineFranNameByPrice(String GoodsName,String FranName,Integer Price);
    List<String> getAllExamineFranNameByPriceAndGoodsID(Integer GoodsID,String GoodsName,String FranName,Integer Price);

    List<Goods> getAllGoods();
    List<Goods> getAllExamineGoods();
    Integer passExamine(Integer GoodsID);
    Integer rejectExamine(Integer GoodsID);
    Goods getGoodsByID(Integer GoodsID);
    ScenicSpot getScenicByID(Integer SSID);
    String getFranName(Integer GoodsID);
    Integer updateGood(Goods goods);
    Integer updateScenic(ScenicSpot scenicSpot);
    List<Goods> getAllNotPassGoods();
    List<Goods> allGoods();

    List<Goods> getAllGoods();
    List<Goods> getGoodsBySSID(ScenicSpot scenicSpot);
    List<Goods> getGoodsByDate(Date date);
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByMeals(int Meals);
    List<Goods> getGoodsByFranID(int ID);
    Integer CreateGoods(Goods goods);
    Integer updateGoods(Goods goods);
    Integer deleteGoods(Integer ID);
}
