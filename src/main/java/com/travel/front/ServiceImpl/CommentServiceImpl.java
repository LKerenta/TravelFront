package com.travel.front.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Comment;
import com.travel.front.Entity.Order;
import com.travel.front.Mapper.CommentMapper;
import com.travel.front.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public PageInfo<Comment> getAllComment(Integer PageSize,Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Comment> commentList = commentMapper.getAllComment();
        PageInfo<Comment> info =new PageInfo<Comment>(commentList);
        return info;
    }

    @Override
    public List<String> getUserNameList() {
        return commentMapper.getUserNameList();
    }

    @Override
    public List<String> getGoodsNameList() {
        return commentMapper.getGoodsNameList();
    }

    @Override
    public List<String> getUserNameListByUserName(String UserName) {
        return commentMapper.getUserNameListByUserName(UserName);
    }

    @Override
    public List<String> getGoodsNameListByUserName(String UserName) {
        return commentMapper.getGoodsNameListByUserName(UserName);
    }

    @Override
    public List<String> getGoodsNameListByGoodsName(String GoodsName) {
        return commentMapper.getGoodsNameListByGoodsName(GoodsName);
    }

    @Override
    public List<String> getUserNameListByGoodsName(String GoodsName) {
        return commentMapper.getUserNameListByGoodsName(GoodsName);
    }

    @Override
    public List<String> getUserNameListByGoodsNameAndUserName(String GoodsName, String UserName) {
        return commentMapper.getUserNameListByGoodsNameAndUserName(GoodsName,UserName);
    }

    @Override
    public List<String> getGoodsNameListByGoodsNameAndUserName(String GoodsName, String UserName) {
        return commentMapper.getGoodsNameListByGoodsNameAndUserName(GoodsName,UserName);
    }


    @Override
    public PageInfo<Comment> getCommentsByUserName(Integer PageSize, Integer PageIndex, String UserName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Comment> list = commentMapper.getCommentsByUserName(UserName);
        PageInfo<Comment> commentList = new PageInfo<Comment>(list);
        return commentList;
    }

    @Override
    public PageInfo<Comment> getCommentsByGoodsName(Integer PageSize, Integer PageIndex, String GoodsName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Comment> list = commentMapper.getCommentsByGoodsName(GoodsName);
        PageInfo<Comment> commentList = new PageInfo<Comment>(list);
        return commentList;
    }

    @Override
    public PageInfo<Comment> getCommentByGoodsNameAndUserName(Integer PageSize, Integer PageIndex, String GoodsName, String UserName) {
        PageHelper.startPage(PageIndex,PageSize);
        List<Comment> list = commentMapper.getCommentByGoodsNameAndUserName(GoodsName,UserName);
        PageInfo<Comment> commentList = new PageInfo<Comment>(list);
        return commentList;
    }

    @Override
    public Integer deleteComment(Integer CID) {
        return commentMapper.deleteComment(CID);
    }

    @Override
    public List<Comment> getCommentByUser(Integer ID) {
        return null;
    }

    @Override
    public List<Comment> getCommentByItem(Integer ID) {
        return commentMapper.getCommentByItem(ID);
    }

    @Override
    public List<String> getUserNameByItem(Integer ID) {
        return commentMapper.getUserNameByItem(ID);
    }

    @Override
    public List<Comment> getCommentByKeyword(String search) {
        return null;
    }

    @Override
    public Integer writeComment(Comment comment) {
        return null;
    }

    @Override
    public Integer updateComment(Comment comment) {
        return null;
    }


    @Override
    public List<Comment> getAllComments() {
        return commentMapper.getAllComment();
    }

    @Override
    public Comment findCommentByID(Integer CID) {
        return commentMapper.findCommentByID(CID);
    }

    @Override
    public String findUserNameByID(Integer CID) {
        return commentMapper.findUserNameByID(CID);
    }

    @Override
    public String findGoodsNameByID(Integer CID) {
        return commentMapper.findGoodsNameByID(CID);
    }
}
