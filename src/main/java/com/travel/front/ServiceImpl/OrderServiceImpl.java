package com.travel.front.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Order;
import com.travel.front.Mapper.OrderMapper;
import com.travel.front.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> getAllOrder(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Order> orders = orderMapper.getAllOrder();
        PageInfo<Order> list = new PageInfo<Order>(orders);
        return list;
    }

    @Override
    public List<String> getAllUserName() {
        return orderMapper.getAllUserName();
    }

    @Override
    public List<String> getAllFranName() {
        return orderMapper.getAllFranName();
    }

    @Override
    public List<String> getAllGoodName() {
        return orderMapper.getAllGoodName();
    }

    @Override
    public PageInfo<Order> getAllOrderByNoStateAndOrderID(Integer PageSize, Integer PageIndex, String UserName, String GoodsName, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Order> orders = orderMapper.getAllOrderByNoStateAndOrderID(UserName,GoodsName,FranName);
        PageInfo<Order> list = new PageInfo<Order>(orders);
        return list;
    }

    @Override
    public List<String> getAllUserNameByNoStateAndOrderID(String UserName, String GoodsName, String FranName) {
        return orderMapper.getAllUserNameByNoStateAndOrderID(UserName,GoodsName,FranName);
    }

    @Override
    public List<String> getAllFranNameByNoStateAndOrderID(String UserName, String GoodsName, String FranName) {
        return orderMapper.getAllFranNameByNoStateAndOrderID(UserName,GoodsName,FranName);
    }

    @Override
    public List<String> getAllGoodNameByNoStateAndOrderID(String UserName, String GoodsName, String FranName) {
        return orderMapper.getAllGoodNameByNoStateAndOrderID(UserName,GoodsName,FranName);
    }

    @Override
    public PageInfo<Order> getAllOrderByOrderID(Integer PageSize, Integer PageIndex,Integer OrderID, String UserName, String GoodsName, String FranName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Order> orders = orderMapper.getAllOrderByOrderID(OrderID,UserName,GoodsName,FranName);
        PageInfo<Order> list = new PageInfo<Order>(orders);
        return list;
    }

    @Override
    public List<String> getAllUserNameByOrderID(Integer OrderID,String UserName, String GoodsName, String FranName) {
        return orderMapper.getAllUserNameByOrderID(OrderID,UserName,GoodsName,FranName);
    }

    @Override
    public List<String> getAllFranNameByOrderID(Integer OrderID,String UserName, String GoodsName, String FranName) {
        return orderMapper.getAllFranNameByOrderID(OrderID,UserName,GoodsName,FranName);
    }

    @Override
    public List<String> getAllGoodNameByOrderID(Integer OrderID,String UserName, String GoodsName, String FranName) {
        return orderMapper.getAllGoodNameByOrderID(OrderID,UserName,GoodsName,FranName);
    }


}
