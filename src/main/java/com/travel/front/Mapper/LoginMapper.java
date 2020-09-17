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

    @Select("SELECT UserID FROM franchise WHERE FranName=#{UserName}")
    Integer getNewIDFran(String UserName);

//    Insert
    @Insert("insert into franchise (Password,FranName,FranImage,WhoInCharge,ChargeID,ChargePhone,Phone,Email,Balance,CreditCard,Introduce)" +
            "values (#{Password},#{FranName},#{FranImage},#{WhoInCharge},#{ChargeID},#{ChargePhone},#{Phone},#{Email},#{Balance},#{CreditCard},#{Introduce})")
    public Integer Registry(Franchise franchise);

    @Insert("insert into usertype (ID,Password,UserType) values (#{ID},#{Password},#{UserType})")
    public Integer userTypeInsert(UserType userType);
}
