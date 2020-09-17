package com.travel.front.ServiceImpl;

import com.travel.front.Entity.Comment;
import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Goods;
import com.travel.front.Entity.Order;
import com.travel.front.Mapper.GoodsMapper;
import com.travel.front.Mapper.OrderMapper;
import com.travel.front.Service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Order> getOrdersByFran(Franchise franchise) {
        return orderMapper.getAllOrderByFran(franchise.getFranID());
    }

    @Override
    public Integer updateOrderState(Order order) {
        return orderMapper.UpdateOrder(order);
    }

    @Override
    public List<Comment> getCommentByGoods(Goods goods) {
//        List<Goods> goods1 =
        return null;
    }
}
