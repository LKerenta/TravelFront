package com.travel.front.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Comment;
import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Goods;
import com.travel.front.Entity.Order;
import com.travel.front.Mapper.FranchiseMapper;
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

    @Autowired
    private FranchiseMapper franchiseMapper;


    @Override
    public List<Order> getOrdersByFran(int franchise) {
        return orderMapper.getAllOrderByFran(franchise);
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

    @Override
    public Franchise getFranByName(String FranName) {
        return franchiseMapper.getFranByName(FranName);
    }

    @Override
    public Integer updateFranInfo(Franchise franchise) {
        return franchiseMapper.updateFran(franchise);
    }

    @Override
    public PageInfo<Franchise> getAllFranchise(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Franchise> frans = franchiseMapper.getAllFranchise();
        PageInfo<Franchise> list = new PageInfo<Franchise>(frans);
        return list;
    }

    @Override
    public PageInfo<Franchise> getFranchiseByNoFranIDAndCreditCard(Integer PageSize, Integer PageIndex, String FranName, String Phone, String Email) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Franchise> frans = franchiseMapper.getFranchiseByNoFranIDAndCreditCard(FranName,Phone,Email);
        PageInfo<Franchise> list = new PageInfo<Franchise>(frans);
        return list;
    }

    @Override
    public PageInfo<Franchise> getFranchiseByFranID(Integer PageSize, Integer PageIndex, Integer FranID, String FranName, String Phone, String Email) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Franchise> frans = franchiseMapper.getFranchiseByFranID(FranID,FranName,Phone,Email);
        PageInfo<Franchise> list = new PageInfo<Franchise>(frans);
        return list;
    }

    @Override
    public PageInfo<Franchise> getFranchiseByCreditCard(Integer PageSize, Integer PageIndex, Integer CreditCard, String FranName, String Phone, String Email) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Franchise> frans = franchiseMapper.getFranchiseByCreditCard(CreditCard,FranName,Phone,Email);
        PageInfo<Franchise> list = new PageInfo<Franchise>(frans);
        return list;
    }

    @Override
    public PageInfo<Franchise> getFranchiseByCreditCardAndFranID(Integer PageSize, Integer PageIndex, Integer FranID, Integer CreditCard, String FranName, String Phone, String Email) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Franchise> frans = franchiseMapper.getFranchiseByCreditCardAndFranID(FranID,CreditCard,FranName,Phone,Email);
        PageInfo<Franchise> list = new PageInfo<Franchise>(frans);
        return list;
    }

    @Override
    public Integer addFran(Franchise franchise) {
        return franchiseMapper.addFran(franchise);
    }

    @Override
    public Franchise findFranByID(Integer FranID) {
        return franchiseMapper.findFranByID(FranID);
    }

    @Override
    public Integer updateFranByID(Franchise franchise) {
        return franchiseMapper.updateFranByID(franchise);
    }

    @Override
    public Integer deleteFranByID(Integer FranID) {
        return franchiseMapper.deleteFranByID(FranID);
    }
}
