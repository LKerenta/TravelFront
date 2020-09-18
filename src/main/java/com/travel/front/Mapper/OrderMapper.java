package com.travel.front.Mapper;

import com.travel.front.Entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("SELECT * From `order`")
    List<Order> getAllOrder();
    @Select("SELECT UserName From `order` JOIN `user` WHERE `user`.UserID=`order`.UserID ORDER BY OrderID")
    List<String> getAllUserName();
    @Select("SELECT FranName From `order` JOIN franchise WHERE franchise.FranID=`order`.FranID ORDER BY OrderID")
    List<String> getAllFranName();
    @Select("SELECT GoodsName From `order` JOIN goods WHERE goods.GoodsID=`order`.GoodsID ORDER BY OrderID")
    List<String> getAllGoodName();

    @Select("SELECT `order`.* From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<Order> getAllOrderByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    @Select("SELECT UserName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<String> getAllUserNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    @Select("SELECT FranName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<String> getAllFranNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    @Select("SELECT GoodsName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<String> getAllGoodNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);

    @Select("SELECT `order`.* From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<Order> getAllOrderByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    @Select("SELECT UserName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<String> getAllUserNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    @Select("SELECT FranName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<String> getAllFranNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    @Select("SELECT GoodsName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') ORDER BY OrderID")
    List<String> getAllGoodNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);

}
