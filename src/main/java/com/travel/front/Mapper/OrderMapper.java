package com.travel.front.Mapper;

import com.travel.front.Entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("SELECT * From `order` where State!=-1")
    List<Order> getAllOrder();
    @Select("SELECT UserName From `order` JOIN `user` WHERE `user`.UserID=`order`.UserID AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllUserName();
    @Select("SELECT FranName From `order` JOIN franchise WHERE franchise.FranID=`order`.FranID AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllFranName();
    @Select("SELECT GoodsName From `order` JOIN goods WHERE goods.GoodsID=`order`.GoodsID AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllGoodName();

    @Select("SELECT `order`.* From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<Order> getAllOrderByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    @Select("SELECT UserName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllUserNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    @Select("SELECT FranName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllFranNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);
    @Select("SELECT GoodsName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllGoodNameByNoStateAndOrderID(String UserName,String GoodsName,String FranName);

    @Select("SELECT `order`.* From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<Order> getAllOrderByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    @Select("SELECT UserName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllUserNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    @Select("SELECT FranName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllFranNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);
    @Select("SELECT GoodsName From `order` JOIN `user` JOIN goods JOIN franchise WHERE `user`.UserID=`order`.UserID AND franchise.FranID=`order`.FranID AND goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') AND FranName LIKE CONCAT('%',#{FranName},'%') AND `order`.State!=-1 ORDER BY OrderID")
    List<String> getAllGoodNameByOrderID(Integer OrderID,String UserName,String GoodsName,String FranName);

    @Update("UPDATE `order` set Price=#{Price} WHERE OrderID=#{OrderID};")
    Integer changePrice(Order order);

    @Select("SELECT * from `order` WHERE OrderID=#{OrderID} AND State!=-1")
    Order findOrderByID(Integer OrderID);

    @Select("SELECT UserName from `order` JOIN `user` WHERE `user`.UserID=`order`.UserID AND OrderID=#{OrderID} AND `order`.State!=-1")
    String findUserNameByID(Integer OrderID);
    @Select("SELECT FranName from `order` JOIN franchise WHERE franchise.FranID=`order`.FranID AND OrderID=#{OrderID} AND `order`.State!=-1")
    String findFranNameByID(Integer OrderID);
    @Select("SELECT GoodsName from `order` JOIN goods WHERE goods.GoodsID=`order`.GoodsID AND OrderID=#{OrderID} AND `order`.State!=-1")
    String findGoodNameByID(Integer OrderID);

    @Select("SELECT * from `order` WHERE UserID=#{UserID} AND State!=-1")
    List<Order> findOrderByUserID(Integer UserID);
    @Select("SELECT FranName from `order` JOIN franchise WHERE franchise.FranID=`order`.FranID AND UserID=#{UserID} AND `order`.State!=-1")
    List<String> findFranNameByUserID(Integer UserID);
    @Select("SELECT GoodsName from `order` JOIN goods WHERE goods.GoodsID=`order`.GoodsID AND UserID=#{UserID} AND `order`.State!=-1")
    List<String> findGoodNameByUserID(Integer UserID);

    @Update("UPDATE `order` SET State=-1 WHERE OrderID=#{OrderID}")
    Integer deleteOrderByID(Integer OrderID);

    @Select("SELECT * FROM `order` WHERE State=4")
    List<Order> getOrdersDrawBack();
    @Select("SELECT UserName FROM `order` JOIN `user` WHERE `user`.UserID=`order`.UserID AND State=4")
    List<String> getUsersDrawBack();
    @Select("SELECT FranName FROM `order` JOIN franchise WHERE franchise.FranID=`order`.FranID AND State=4")
    List<String> getFransDrawBack();
    @Select("SELECT GoodsName FROM `order` JOIN goods WHERE goods.GoodsID=`order`.GoodsID AND `order`.State=4")
    List<String> getGoodsDrawBack();

    @Select("SELECT * FROM `order` WHERE State>0 AND State<5")
    List<Order> getOrdersWaitForPay();
    @Select("SELECT UserName FROM `order` JOIN `user` WHERE `user`.UserID=`order`.UserID AND State>0 AND State<5")
    List<String> getUsersWaitForPay();
    @Select("SELECT FranName FROM `order` JOIN franchise WHERE franchise.FranID=`order`.FranID AND State>0 AND State<5")
    List<String> getFransWaitForPay();
    @Select("SELECT GoodsName FROM `order` JOIN goods WHERE goods.GoodsID=`order`.GoodsID AND `order`.State>0 AND `order`.State<5")
    List<String> getGoodsWaitForPay();

    @Update("UPDATE `order` SET State=5 WHERE OrderID=#{OrderID};UPDATE `user` SET `user`.Balance=`user`.Balance+#{Price} WHERE UserID=#{UserID};")
    Integer drawBackByID(Order order);
    @Update("UPDATE `order` SET State=7 WHERE OrderID=#{OrderID}")
    Integer rejectDrawBackByID(Integer OrderID);

    @Update("UPDATE `order` SET State=4 WHERE OrderID=#{OrderID}")
    Integer requestDrawBack(Order order);

    @Select("SELECT * from `order` WHERE State=6")
    List<Order> getAllDoneOrder();
    @Select("SELECT * FROM `order` WHERE (State>=0 AND State<5) OR State=7")
    List<Order> getNotEndOrders();
    @Select("SELECT * FROM `order` WHERE State=5")
    List<Order> getDrawBackDoneOrders();

    @Update("UPDATE `order` SET State=6 WHERE OrderID=#{order.OrderID};UPDATE franchise SET Balance=Balance+#{order.Price}*0.6 WHERE FranID=#{order.FranID};UPDATE manager SET Balance=Balance+#{order.Price}*0.4 WHERE MaID=#{MaID};")
    Integer payToFran(Order order,Integer MaID);
    //    SELECT
    @Select("SELECT * FROM `order` WHERE FranID=#{ID}")
    List<Order> getAllOrderByFran(Integer ID);

    @Select("SELECT * FROM `order` WHERE UserID=#{ID}")
    List<Order> getAllOrderByUser(Integer ID);

    @Select("SELECT * FROM `order` WHERE GoodsID=#{ID}")
    List<Order> getAllOrderByGoods(Integer ID);


    //    INSERT
    @Insert("INSERT INTO `order` (GoodsID,Price,UserID,State,FranID,Date) VALUES(#{GoodsID},#{Price},#{UserID},#{State},#{FranID},#{Date})")
    Integer CreateOrder(Order order);

    //    Update
    @Update("UPDATE `order` SET state=#{state} WHERE OrderID=#{OrderID}")
    Integer UpdateOrder(Order order);

    //    Delete
    @Delete("DELETE FROM `order` WHERE OrderID=#{OrderID}")
    Integer DeleteOrder(Order order);
}
