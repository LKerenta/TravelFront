package com.travel.front.Mapper;

import com.travel.front.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TouristMapper {
    @Select("select * from user where UserID=#{ID}")
    public User getUserByID(Integer ID);
    /*private String Password;
    private String UserImage;
    private String TrueName;
    private String IDNumber;
    private int QQNumber;
    private String Phone;
    private String Email;
    private int Balance;
    private String Tag1;
    private String Tag2;
    private String Tag3;
    private String Introduce;*/
    @Insert("insert into user (Password,UserImage,TrueName,IDNumber,QQNumber,Phone,Email,Balance,Tag1,Tag2,Tag3,Introduce)" +
            "values (#{Password},#{UserImage},#{TrueName},#{IDNumber},#{QQNumber},#{Phone},#{Email},#{Balance},#{Tag1},#{Tag2},#{Tag3},#{Introduce})")
    public Integer Registry(User user);
}
