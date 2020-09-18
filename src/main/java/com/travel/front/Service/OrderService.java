package com.travel.front.Service;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Order;

import java.util.List;

public interface OrderService {
    PageInfo<Order> getAllOrder(Integer PageSize,Integer PageIndex);
    List<String> getAllUserName();
    List<String> getAllFranName();
    List<String> getAllGoodName();

    PageInfo<Order> getAllOrderByNoStateAndOrderID(Integer PageSize,Integer PageIndex,String UserName,String GoodsName,String FranName);
    List<String> getAllUserNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    List<String> getAllFranNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    List<String> getAllGoodNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);

    PageInfo<Order> getAllOrderByOrderID(Integer PageSize,Integer PageIndex,Integer OrderID,String UserName,String GoodsName,String FranName);
    List<String> getAllUserNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    List<String> getAllFranNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    List<String> getAllGoodNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);

}
