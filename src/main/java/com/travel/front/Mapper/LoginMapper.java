package com.travel.front.Mapper;

import com.travel.front.Entity.UserType;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {
    @Select("SELECT * from usertype WHERE ID=#{ID} and Password=#{Password}")
    UserType login(UserType userType);
}
