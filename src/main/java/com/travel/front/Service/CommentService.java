package com.travel.front.Service;

import com.travel.front.Entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    List<Comment> getCommentByUser(Integer ID);
    List<Comment> getCommentByItem(Integer ID);
    List<Comment> getCommentByKeyword(String search);
    Integer writeComment(Comment comment);
    Integer updateComment(Comment comment);
    Integer deleteComment(Comment comment);
}
