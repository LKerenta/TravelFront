package com.travel.front.Mapper;

import com.travel.front.Entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * from comment")
    List<Comment> getAllComment();

    @Select("SELECT UserName from user JOIN comment where comment.UserID=user.UserID")
    List<String> getUserNameList();

    @Select("SELECT GoodsName from goods JOIN comment where goods.GoodsID=comment.GoodsID")
    List<String> getGoodsNameList();

    @Select("SELECT comment.* from comment JOIN user where user.UserID=comment.UserID and user.UserName=#{UserName}")
    List<Comment> getCommentsByUserName(String UserName);

    @Select("SELECT comment.* from goods JOIN comment where comment.GoodsID=goods.GoodsID and goods.GoodsName=#{GoodsName}")
    List<Comment> getCommentsByGoodsName(String GoodsName);

    @Select("SELECT comment.* from comment JOIN user JOIN goods where user.UserID=comment.UserID and user.UserName=#{UserName} and goods.GoodsName=#{GoodsName} and goods.GoodsID=comment.GoodsID")
    List<Comment> getCommentByGoodsNameAndUserName(String GoodsName,String UserName);

    @Select("SELECT UserName from comment JOIN user where user.UserID=comment.UserID and user.UserName=#{UserName}")
    List<String> getUserNameListByUserName(String UserName);

    @Select("SELECT GoodsName from comment JOIN user JOIN goods where user.UserID=comment.UserID and user.UserName=#{UserName} and goods.GoodsID=comment.GoodsID")
    List<String> getGoodsNameListByUserName(String UserName);

    @Select("SELECT GoodsName from comment JOIN goods where goods.GoodsID=comment.GoodsID and goods.GoodsName=#{GoodsName}")
    List<String> getGoodsNameListByGoodsName(String GoodsName);

    @Select("SELECT UserName from comment JOIN user JOIN goods where goods.GoodsName=#{GoodsName} and user.UserID=comment.UserID and goods.GoodsID=comment.GoodsID")
    List<String> getUserNameListByGoodsName(String GoodsName);

    @Select("SELECT UserName from comment JOIN user JOIN goods where user.UserID=comment.UserID and user.UserName=#{UserName} and goods.GoodsName=#{GoodsName} and goods.GoodsID=comment.GoodsID")
    List<String> getUserNameListByGoodsNameAndUserName(String GoodsName,String UserName);

    @Select("SELECT GoodsName from comment JOIN user JOIN goods where user.UserID=comment.UserID and user.UserName=#{UserName} and goods.GoodsName=#{GoodsName} and goods.GoodsID=comment.GoodsID")
    List<String> getGoodsNameListByGoodsNameAndUserName(String GoodsName,String UserName);

    @Delete("DELETE from comment where CID=#{CID}")
    Integer deleteComment(Integer CID);

    @Select("SELECT * from `comment` WHERE CID=#{CID}")
    Comment findCommentByID(Integer CID);
    @Select("SELECT UserName from `comment` JOIN `user` WHERE `user`.UserID=`comment`.UserID AND CID=#{CID}")
    String findUserNameByID(Integer CID);
    @Select("SELECT GoodsName from `comment` JOIN goods WHERE goods.GoodsID=`comment`.GoodsID AND CID=#{CID}")
    String findGoodsNameByID(Integer CID);

    @Select("select * from comment where UserID=#{ID}")
    List<Comment> getCommentByUser(Integer ID);

    @Select("select * from comment where GoodsID=#{ID}")
    List<Comment> getCommentByItem(Integer ID);

    @Select("select * from comment where CText like '%${search}%'")
    List<Comment> getCommentByKeyword(String search);
    //    Insert
    @Insert("insert into comment (GoodsID,UserID,CText) values (#{GoodsID},#{UserID},#{CText})")
    Integer writeComment(Comment comment);

    //    Update
    @Update("update comment set CText=#{CText} where UserID=#{UserID} and GoodsID=#{GoodsID}")
    Integer updateComment(Comment comment);
}
