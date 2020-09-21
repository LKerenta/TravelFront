package com.travel.front.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<Goods> getAllGoods(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoods();
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getGoodsByGoodName(Integer PageSize, Integer PageIndex, String GoodName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getGoodsByGoodName(GoodName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getGoodsByGoodID(Integer PageSize, Integer PageIndex, Integer GoodID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodID(GoodID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getGoodsByPrice(Integer PageSize, Integer PageIndex, Integer Price) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByPrice(Price);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getGoodsByFranName(Integer PageSize, Integer PageIndex, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByFranName(FranName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getGoodsByFranNameAndGoodsName(Integer PageSize, Integer PageIndex, String GoodsName, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByFranNameAndGoodsName(GoodsName,FranName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByPriceAndGoodsName(Integer PageSize, Integer PageIndex, String GoodsName, Integer Price) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByPriceAndGoodsName(GoodsName,Price);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByPriceAndFranName(Integer PageSize, Integer PageIndex, String FranName, Integer Price) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByPriceAndFranName(FranName,Price);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsIDAndFranName(Integer PageSize, Integer PageIndex, String FranName, Integer GoodsID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsIDAndFranName(FranName,GoodsID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsIDAndGoodsName(Integer PageSize, Integer PageIndex, String GoodsName, Integer GoodsID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsIDAndGoodsName(GoodsName,GoodsID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsIDAndPrice(Integer PageSize, Integer PageIndex, Integer Price, Integer GoodsID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsIDAndPrice(Price,GoodsID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsNameAndFranNameAndPrice(Integer PageSize, Integer PageIndex, Integer Price, String GoodsName, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsNameAndFranNameAndPrice(Price,GoodsName,FranName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsIDAndFranNameAndPrice(Integer PageSize, Integer PageIndex, Integer Price, Integer GoodsID, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsIDAndFranNameAndPrice(Price,GoodsID,FranName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsNameAndFranNameAndGoodsID(Integer PageSize, Integer PageIndex, Integer GoodsID, String GoodsName, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsNameAndFranNameAndGoodsID(GoodsID,GoodsName,FranName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsNameAndGoodsIDAndPrice(Integer PageSize, Integer PageIndex, Integer Price, String GoodsName, Integer GoodsID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsNameAndGoodsIDAndPrice(Price,GoodsName,GoodsID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllGoodsByGoodsNameAndGoodsIDAndPriceAndFranName(Integer PageSize, Integer PageIndex, String FranName, Integer Price, String GoodsName, Integer GoodsID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllGoodsByGoodsNameAndGoodsIDAndPriceAndFranName(FranName,Price,GoodsName,GoodsID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }


    @Override
    public List<String> getAllFranName() {
        return goodsMapper.getAllFranName();
    }

    @Override
    public List<String> getAllFranNameByGoodName(String GoodName) {
        return goodsMapper.getAllFranNameByGoodName(GoodName);
    }

    @Override
    public List<String> getAllFranNameByGoodID(Integer GoodID) {
        return goodsMapper.getAllFranNameByGoodID(GoodID);
    }

    @Override
    public List<String> getAllFranNameByPrice(Integer Price) {
        return goodsMapper.getAllFranNameByPrice(Price);
    }

    @Override
    public List<String> getAllFranNameByFranName(String FranName) {
        return goodsMapper.getAllFranNameByFranName(FranName);
    }

    @Override
    public List<String> getAllFranNameByFranNameAndGoodsName(String GoodsName, String FranName) {
        return goodsMapper.getAllFranNameByFranNameAndGoodsName(GoodsName,FranName);
    }

    @Override
    public List<String> getAllFranNameByPriceAndGoodsName(String GoodsName, Integer Price) {
        return goodsMapper.getAllFranNameByPriceAndGoodsName(GoodsName,Price);
    }

    @Override
    public List<String> getAllFranNameByPriceAndFranName(String FranName, Integer Price) {
        return goodsMapper.getAllFranNameByPriceAndFranName(FranName,Price);
    }

    @Override
    public List<String> getAllFranNameByGoodsIDAndFranName(String FranName, Integer GoodsID) {
        return goodsMapper.getAllFranNameByGoodsIDAndFranName(FranName,GoodsID);
    }

    @Override
    public List<String> getAllFranNameByGoodsIDAndGoodsName(String GoodsName, Integer GoodsID) {
        return goodsMapper.getAllFranNameByGoodsIDAndGoodsName(GoodsName,GoodsID);
    }

    @Override
    public List<String> getAllFranNameByGoodsIDAndPrice(Integer Price, Integer GoodsID) {
        return goodsMapper.getAllFranNameByGoodsIDAndPrice(Price,GoodsID);
    }

    @Override
    public List<String> getAllFranNameByGoodsNameAndFranNameAndPrice(Integer Price, String GoodsName, String FranName) {
        return goodsMapper.getAllFranNameByGoodsNameAndFranNameAndPrice(Price,GoodsName,FranName);
    }

    @Override
    public List<String> getAllFranNameByGoodsIDAndFranNameAndPrice(Integer Price, Integer GoodsID, String FranName) {
        return goodsMapper.getAllFranNameByGoodsIDAndFranNameAndPrice(Price,GoodsID,FranName);
    }

    @Override
    public List<String> getAllFranNameByGoodsNameAndFranNameAndGoodsID(Integer GoodsID, String GoodsName, String FranName) {
        return goodsMapper.getAllFranNameByGoodsNameAndFranNameAndGoodsID(GoodsID,GoodsName,FranName);
    }

    @Override
    public List<String> getAllFranNameByGoodsNameAndGoodsIDAndPrice(Integer Price, String GoodsName, Integer GoodsID) {
        return goodsMapper.getAllFranNameByGoodsNameAndGoodsIDAndPrice(Price,GoodsName,GoodsID);
    }

    @Override
    public List<String> getAllFranNameByGoodsNameAndGoodsIDAndPriceAndFranName(String FranName, Integer Price, String GoodsName, Integer GoodsID) {
        return goodsMapper.getAllFranNameByGoodsNameAndGoodsIDAndPriceAndFranName(FranName,Price,GoodsName,GoodsID);
    }

    @Override
    public Integer deleteGoodsByGoodsID(Integer GoodsID) {
        return goodsMapper.deleteGoodsByGoodsID(GoodsID);
    }

    @Override
    public PageInfo<Goods> getAllExamineGoods(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllExamineGoods();
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllExamineGoodsWithOutGoodsIDAndPrice(Integer PageSize, Integer PageIndex, String GoodsName, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllExamineGoodsWithOutGoodsIDAndPrice(GoodsName,FranName);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllExamineGoodsByGoodsID(Integer PageSize, Integer PageIndex, String GoodsName, String FranName, Integer GoodsID) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllExamineGoodsByGoodsID(GoodsName,FranName,GoodsID);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllExamineGoodsByPrice(Integer PageSize, Integer PageIndex, String GoodsName, String FranName, Integer Price) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllExamineGoodsByPrice(GoodsName,FranName,Price);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public PageInfo<Goods> getAllExamineGoodsByPriceAndGoodsID(Integer PageSize, Integer PageIndex, Integer GoodsID, String GoodsName, String FranName, Integer Price) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Goods> goods = goodsMapper.getAllExamineGoodsByPriceAndGoodsID(GoodsID,GoodsName,FranName,Price);
        PageInfo<Goods> list = new PageInfo<Goods>(goods);
        return list;
    }

    @Override
    public List<String> getAllExamineFranName() {
        return goodsMapper.getAllExamineFranName();
    }

    @Override
    public List<String> getAllExamineFranNameWithOutGoodsIDAndPrice(String GoodsName, String FranName) {
        return goodsMapper.getAllExamineFranNameWithOutGoodsIDAndPrice(GoodsName,FranName);
    }

    @Override
    public List<String> getAllExamineFranNameByGoodsID(String GoodsName, String FranName, Integer GoodsID) {
        return goodsMapper.getAllExamineFranNameByGoodsID(GoodsName,FranName,GoodsID);
    }

    @Override
    public List<String> getAllExamineFranNameByPrice(String GoodsName, String FranName, Integer Price) {
        return goodsMapper.getAllExamineFranNameByPrice(GoodsName,FranName,Price);
    }

    @Override
    public List<String> getAllExamineFranNameByPriceAndGoodsID(Integer GoodsID, String GoodsName, String FranName, Integer Price) {
        return goodsMapper.getAllExamineFranNameByPriceAndGoodsID(GoodsID,GoodsName,FranName,Price);
    }


    @Override
    public List<Goods> getAllExamineGoods() {
        return goodsMapper.getAllExamineGoods();
    }

    @Override
    public Integer passExamine(Integer GoodsID) {
        return goodsMapper.passExamine(GoodsID);
    }

    @Override
    public Integer rejectExamine(Integer GoodsID) {
        return goodsMapper.rejectExamine(GoodsID);
    }

    @Override
    public Goods getGoodsByID(Integer GoodsID) {
        return goodsMapper.getGoodsByID(GoodsID);
    }

    @Override
    public ScenicSpot getScenicByID(Integer SSID) {
        return goodsMapper.getScenicByID(SSID);
    }

    @Override
    public String getFranName(Integer GoodsID) {
        return goodsMapper.getFranName(GoodsID);
    }

    @Override
    public Integer updateGood(Goods goods) {
        return goodsMapper.updateGood(goods);
    }

    @Override
    public Integer updateScenic(ScenicSpot scenicSpot) {
        return goodsMapper.updateScenic(scenicSpot);
    }

    @Override
    public List<Goods> getAllNotPassGoods() {
        return goodsMapper.getAllNotPassGoods();
    }

    @Override
    public List<Goods> allGoods() {
        return goodsMapper.allGoods();
    }

}
