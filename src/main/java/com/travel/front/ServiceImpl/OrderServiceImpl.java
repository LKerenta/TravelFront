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

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    @Override
    public Integer changePrice(Order order) {
        return orderMapper.changePrice(order);
    }

    @Override
    public Order findOrderByID(Integer OrderID) {
        return orderMapper.findOrderByID(OrderID);
    }

    @Override
    public String findUserNameByID(Integer OrderID) {
        return orderMapper.findUserNameByID(OrderID);
    }

    @Override
    public String findFranNameByID(Integer OrderID) {
        return orderMapper.findFranNameByID(OrderID);
    }

    @Override
    public String findGoodNameByID(Integer OrderID) {
        return orderMapper.findGoodNameByID(OrderID);
    }

    @Override
    public PageInfo<Order> getOrdersDrawBack(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Order> orders = orderMapper.getOrdersDrawBack();
        PageInfo<Order> list = new PageInfo<Order>(orders);
        return list;
    }

    @Override
    public List<String> getUsersDrawBack() {
        return orderMapper.getUsersDrawBack();
    }

    @Override
    public List<String> getFransDrawBack() {
        return orderMapper.getFransDrawBack();
    }

    @Override
    public List<String> getGoodsDrawBack() {
        return orderMapper.getGoodsDrawBack();
    }

    @Override
    public PageInfo<Order> getOrdersWaitForPay(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Order> orders = orderMapper.getOrdersWaitForPay();
        PageInfo<Order> list = new PageInfo<Order>(orders);
        return list;
    }

    @Override
    public List<Order> getOrdersWaitForPay() {
        return orderMapper.getOrdersWaitForPay();
    }

    @Override
    public List<String> getUsersWaitForPay() {
        return orderMapper.getUsersWaitForPay();
    }

    @Override
    public List<String> getFransWaitForPay() {
        return orderMapper.getFransWaitForPay();
    }

    @Override
    public List<String> getGoodsWaitForPay() {
        return orderMapper.getGoodsWaitForPay();
    }

    @Override
    public Integer drawBackByID(Order order) {
        return orderMapper.drawBackByID(order);
    }

    @Override
    public Integer rejectDrawBackByID(Integer OrderID) {
        return orderMapper.rejectDrawBackByID(OrderID);
    }

    @Override
    public List<Order> getAllDoneOrder() {
        return orderMapper.getAllDoneOrder();
    }

    @Override
    public Integer payToFran(Order order,Integer MaID) {
        return orderMapper.payToFran(order,MaID);
    }

    @Override
    public List<Order> getNotEndOrders() {
        return orderMapper.getNotEndOrders();
    }

    @Override
    public List<Order> getDrawBackDoneOrders() {
        return orderMapper.getDrawBackDoneOrders();
    }

    @Override
    public Integer deleteOrderByID(Integer OrderID) {
        return orderMapper.deleteOrderByID(OrderID);
    }


}
