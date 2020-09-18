package com.travel.front.Mapper;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FranchiseMapper {
//    Select
    @Select("select * from franchise where FranName=#{FranName}")
    Franchise getFranByName(String FranName);
//    Update
    @Update("update franchise set FranName=#{FranName},Password=#{Password},WhoInCharge=#{WhoInCharge},ChargeID=#{ChargeID},ChargePhone=#{ChargePhone},Phone=#{Phone},Email=#{Email},CreditCard=#{CreditCard},Introduce=#{Introduce} where FranName=#{FranName}")
    Integer updateFran(Franchise franchise);

}
