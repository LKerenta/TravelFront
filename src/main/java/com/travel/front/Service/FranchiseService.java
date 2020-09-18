package com.travel.front.Service;

import com.travel.front.Entity.Comment;
import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Goods;
import com.travel.front.Entity.Order;

import java.util.List;

public interface FranchiseService {
    List<Order> getOrdersByFran(int franchise);
    Integer updateOrderState(Order order);
    List<Comment> getCommentByGoods(Goods goods);
    Franchise getFranByName(String FranName);
    Integer updateFranInfo(Franchise franchise);

}
