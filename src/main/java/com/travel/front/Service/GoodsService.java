package com.travel.front.Service;

import com.travel.front.Entity.Goods;
import com.travel.front.Entity.ScenicSpot;

import java.sql.Date;
import java.util.List;

public interface GoodsService {
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
