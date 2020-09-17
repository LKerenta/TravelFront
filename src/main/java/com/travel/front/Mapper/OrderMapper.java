package com.travel.front.Mapper;

import com.travel.front.Entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    //    SELECT
    @Select("SELECT * FROM `order` WHERE FranID=#{ID}")
    List<Order> getAllOrderByFran(Integer ID);

    @Select("SELECT * FROM `order` WHERE UserID=#{ID}")
    List<Order> getAllOrderByUser(Integer ID);

    @Select("SELECT * FROM `order` WHERE GoodsID=#{ID}")
    List<Order> getAllOrderByGoods(Integer ID);

    @Select("SELECT * FROM `order`")
    List<Order> getAllOrder();

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
