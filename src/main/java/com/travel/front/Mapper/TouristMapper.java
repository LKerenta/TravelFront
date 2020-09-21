package com.travel.front.Mapper;

import com.travel.front.Entity.User;
import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO `user` (UserName,Password,UserImage,TrueName,IDNumber,QQNumber,Phone,Email,Balance,Introduce) VALUES(#{UserName},#{Password},#{UserImage},#{TrueName},#{IDNumber},#{QQNumber},#{Phone},#{Email},#{Balance},#{Introduce})")
    Integer addUser(User user);

    @Select("SELECT * from `user` where UserID=#{UserID}")
    User findUserByID(Integer UserID);

    @Update("UPDATE `user` SET UserName=#{UserName},Password=#{Password},UserImage=#{UserImage},TrueName=#{TrueName},IDNumber=#{IDNumber},QQNumber=#{QQNumber},Phone=#{Phone},Email=#{Email},Introduce=#{Introduce} WHERE UserID=#{UserID}")
    Integer updateUserByID(User user);

    @Delete("DELETE FROM `user` WHERE UserID=#{UserID}")
    Integer deleteUserByID(Integer UserID);
}
