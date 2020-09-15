package com.travel.front.Mapper;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Entity.UserType;
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
}
