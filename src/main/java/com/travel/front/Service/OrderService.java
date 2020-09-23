package com.travel.front.Service;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Order;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

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

    List<Order> getAllOrder();
    Integer changePrice(Order order);
    Order findOrderByID(Integer OrderID);
    String findUserNameByID(Integer OrderID);
    String findFranNameByID(Integer OrderID);
    String findGoodNameByID(Integer OrderID);

    PageInfo<Order> getOrdersDrawBack(Integer PageSize,Integer PageIndex);
    List<String> getUsersDrawBack();
    List<String> getFransDrawBack();
    List<String> getGoodsDrawBack();

    PageInfo<Order> getOrdersWaitForPay(Integer PageSize,Integer PageIndex);
    List<Order> getOrdersWaitForPay();
    List<String> getUsersWaitForPay();
    List<String> getFransWaitForPay();
    List<String> getGoodsWaitForPay();

    Integer drawBackByID(Order order);
    Integer rejectDrawBackByID(Integer OrderID);
    List<Order> getAllDoneOrder();
    Integer payToFran(Order order,Integer MaID);
    List<Order> getNotEndOrders();
    List<Order> getDrawBackDoneOrders();
    Integer deleteOrderByID(Integer OrderID);

    PageInfo<Order> findOrderByUserID(Integer PageSize,Integer PageIndex,Integer UserID);
    List<String> findFranNameByUserID(Integer UserID);
    List<String> findGoodNameByUserID(Integer UserID);

    Integer CreateOrder(Order order);
}
