package com.travel.front.Mapper;

import com.travel.front.Entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
//    Select
    @Select("select * from comment")
    List<Comment> getAllComments();

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

//    Delete
    @Delete("delete from comment where UserID=#{UserID} and GoodsID=#{GoodsID}")
    Integer deleteComment(Comment comment);
}
