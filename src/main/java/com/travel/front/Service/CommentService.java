package com.travel.front.Service;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Comment;
import com.travel.front.Entity.Order;

import java.util.List;


public interface CommentService {
    PageInfo<Comment> getAllComment(Integer PageSize,Integer PageIndex);

    List<String> getUserNameList();
    List<String> getGoodsNameList();
    List<String> getUserNameListByUserName(String UserName);
    List<String> getGoodsNameListByUserName(String UserName);
    List<String> getGoodsNameListByGoodsName(String GoodsName);
    List<String> getUserNameListByGoodsName(String GoodsName);
    List<String> getUserNameListByGoodsNameAndUserName(String GoodsName,String UserName);
    List<String> getGoodsNameListByGoodsNameAndUserName(String GoodsName,String UserName);

    PageInfo<Comment> getCommentsByUserName(Integer PageSize,Integer PageIndex,String UserName);
    PageInfo<Comment> getCommentsByGoodsName(Integer PageSize,Integer PageIndex,String GoodsName);
    PageInfo<Comment> getCommentByGoodsNameAndUserName(Integer PageSize,Integer PageIndex,String GoodsName,String UserName);

    Integer deleteComment(Integer CID);
    List<Comment> getAllComment();

    Comment findCommentByID(Integer CID);
    String findUserNameByID(Integer CID);
    String findGoodsNameByID(Integer CID);
}
