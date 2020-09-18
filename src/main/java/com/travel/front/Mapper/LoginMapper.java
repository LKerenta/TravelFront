package com.travel.front.Mapper;

import com.travel.front.Entity.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {
    @Select("SELECT * from usertype WHERE ID=#{ID} and Password=#{Password}")
    UserType login(UserType userType);

    @Select("SELECT * FROM user WHERE UserID=#{ID} AND Password=#{Password}")
    User RT(UserType userType);

    @Select("SELECT * FROM franchise WHERE FranID=#{ID} AND Password=#{Password}")
    Franchise RF(UserType userType);

    @Select("SELECT * FROM manager WHERE MaID=#{ID} AND Password=#{Password}")
    Manager RM(UserType userType);

    @Select("SELECT FranID FROM franchise WHERE FranName=#{UserName}")
    Integer getNewIDFran(String UserName);

    @Select("select * from user where UserName=#{UserName}")
    Integer getNewUserID(String UserName);

    @Select("select * from `login`")
    Login getLoginUser();

//    Insert
    @Insert("insert into franchise (Password,FranName,FranImage,WhoInCharge,ChargeID,ChargePhone,Phone,Email,Balance,CreditCard,Introduce)" +
            "values (#{Password},#{FranName},#{FranImage},#{WhoInCharge},#{ChargeID},#{ChargePhone},#{Phone},#{Email},#{Balance},#{CreditCard},#{Introduce})")
    Integer RegistryF(Franchise franchise);

    @Insert("insert into user (Password,UserName,UserImage,TrueName,IDNumber,QQNumber,Phone,Email,Balance,Tag1,Tag2,Tag3,Introduce)" +
            "values (#{Password},#{UserName},#{UserImage},#{TrueName},#{IDNumber},#{QQNumber},#{Phone},#{Email},#{Balance},#{Tag1},#{Tag2},#{Tag3},#{Introduce})")
    Integer RegistryU(User user);

    @Insert("insert into usertype (ID,Password,Type) values (#{ID},#{Password},#{Type})")
    Integer userTypeInsert(UserType userType);

    @Insert("insert into `login` (ID,Name,Type) values (#{user.UserID},#{user.UserName},#{type})")
    Integer loginStatus(User user,Integer type);

//    Delete
    @Delete("delete from `login`")
    Integer LogOut();
}
