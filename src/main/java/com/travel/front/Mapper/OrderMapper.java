package com.travel.front.Mapper;

import com.travel.front.Entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    //    SELECT
    @Select("SELECT * FROM `order` WHERE FranID=#{ID}")
    List<Order> getAllOrderByFran(Integer ID);

    @Select("SELECT * FROM `order` WHERE UserID=#{ID}")
    List<Order> getAllOrderByUser(Integer ID);

    @Select("SELECT * FROM `order` WHERE GoodsID=#{ID}")
    List<Order> getAllOrderByGoods(Integer ID);


    //    INSERT
    @Insert("INSERT INTO `order` (OrderID,GoodsID,Price,UserID,State,FranID) " +
            "VALUES(#{OrderID},#{GoodsID},#{Price},#{UserID},#{State},#{FranID})")
    Integer CreateOrder(Order order);

    //    Update
    @Update("UPDATE `order` SET state=#{state} WHERE OrderID=#{OrderID}")
    Integer UpdateOrder(Order order);

    //    Delete
    @Delete("DELETE FROM `order` WHERE OrderID=#{OrderID}")
    Integer DeleteOrder(Order order);
}
