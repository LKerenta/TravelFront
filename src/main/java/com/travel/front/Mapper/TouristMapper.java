package com.travel.front.Mapper;

import com.travel.front.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TouristMapper {
    @Select("SELECT * from user")
    List<User> getAllUser();

    @Select("SELECT * from user where UserName LIKE CONCAT('%',#{UserName},'%') AND TrueName LIKE CONCAT('%',#{TrueName},'%') AND IDNumber LIKE CONCAT('%',#{IDNumber},'%') AND Phone LIKE CONCAT('%',#{Phone},'%') AND Email LIKE CONCAT('%',#{Email},'%')")
    List<User> getUsersByNoQQNumberAndUserID(String UserName,String TrueName,String IDNumber,String Email,String Phone);

    @Select("SELECT * from user where UserID=#{UserID} AND UserName LIKE CONCAT('%',#{UserName},'%') AND TrueName LIKE CONCAT('%',#{TrueName},'%') AND IDNumber LIKE CONCAT('%',#{IDNumber},'%') AND Phone LIKE CONCAT('%',#{Phone},'%') AND Email LIKE CONCAT('%',#{Email},'%')")
    List<User> getUsersByUserID(Integer UserID,String UserName,String TrueName,String IDNumber,String Email,String Phone);

    @Select("SELECT * from user where QQNumber=#{QQNumber} AND UserName LIKE CONCAT('%',#{UserName},'%') AND TrueName LIKE CONCAT('%',#{TrueName},'%') AND IDNumber LIKE CONCAT('%',#{IDNumber},'%') AND Phone LIKE CONCAT('%',#{Phone},'%') AND Email LIKE CONCAT('%',#{Email},'%')")
    List<User> getUsersByQQNumber(Integer QQNumber,String UserName,String TrueName,String IDNumber,String Email,String Phone);

    @Select("SELECT * from user where UserID=#{UserID} AND QQNumber=#{QQNumber} AND UserName LIKE CONCAT('%',#{UserName},'%') AND TrueName LIKE CONCAT('%',#{TrueName},'%') AND IDNumber LIKE CONCAT('%',#{IDNumber},'%') AND Phone LIKE CONCAT('%',#{Phone},'%') AND Email LIKE CONCAT('%',#{Email},'%')")
    List<User> getUsersByUserIDAndQQNumber(Integer UserID,Integer QQNumber,String UserName,String TrueName,String IDNumber,String Email,String Phone);
}
