package com.travel.front.Mapper;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Entity.UserType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.ServerEndpoint;

@Mapper
public interface LoginMapper {

    @Select("SELECT * from usertype where ID=#{ID} and Password=#{Password}")
    UserType login(UserType userType);

    @Select("SELECT * FROM user where UserID=#{ID} and Password=#{Password}")
    User RT(UserType userType);

    @Select("SELECT * from franchise where FranID=#{ID} and Password=#{Password}")
    Franchise RF(UserType userType);

    @Select("SELECT * from manager where MaID=#{ID} and Password=#{Password}")
    Manager RM(UserType userType);
}
