package com.travel.front.ServiceImpl;

import com.travel.front.Entity.Goods;
import com.travel.front.Entity.ScenicSpot;
import com.travel.front.Mapper.GoodsMapper;
import com.travel.front.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public List<Goods> getGoodsBySSID(ScenicSpot scenicSpot) {
        return goodsMapper.getGoodsBySSID(scenicSpot);
    }

    @Override
    public List<Goods> getGoodsByDate(Date date) {
        return goodsMapper.getGoodsByDate(date);
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        return goodsMapper.getGoodsByName(name);
    }

    @Override
    public List<Goods> getGoodsByMeals(int Meals) {
        return goodsMapper.getGoodsByMeals(Meals);
    }

    @Override
    public List<Goods> getGoodsByFranID(int ID) {
        return goodsMapper.getGoodsByFranID(ID);
    }

    @Override
    public Integer CreateGoods(Goods goods) {
        return goodsMapper.CreateGoods(goods);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public Integer deleteGoods(Integer ID) {
        return goodsMapper.deleteGoods(ID);
    }
}
