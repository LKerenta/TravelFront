package com.travel.front.Mapper;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FranchiseMapper {
    @Select("SELECT * from franchise")
    List<Franchise> getAllFranchise();

    @Select("SELECT * from franchise WHERE FranName LIKE CONCAT('%',#{FranName},'%') AND Email LIKE CONCAT('%',#{Email},'%') AND Phone LIKE CONCAT('%',#{Phone},'%')")
    List<Franchise> getFranchiseByNoFranIDAndCreditCard(String FranName,String Phone,String Email);

    @Select("SELECT * from franchise WHERE FranID=#{FranID} AND FranName LIKE CONCAT('%',#{FranName},'%') AND Email LIKE CONCAT('%',#{Email},'%') AND Phone LIKE CONCAT('%',#{Phone},'%')")
    List<Franchise> getFranchiseByFranID(Integer FranID,String FranName,String Phone,String Email);

    @Select("SELECT * from franchise WHERE CreditCard=#{CreditCard} AND FranName LIKE CONCAT('%',#{FranName},'%') AND Email LIKE CONCAT('%',#{Email},'%') AND Phone LIKE CONCAT('%',#{Phone},'%')")
    List<Franchise> getFranchiseByCreditCard(Integer CreditCard,String FranName,String Phone,String Email);

    @Select("SELECT * from franchise WHERE CreditCard=#{CreditCard} AND FranID=#{FranID} AND FranName LIKE CONCAT('%',#{FranName},'%') AND Email LIKE CONCAT('%',#{Email},'%') AND Phone LIKE CONCAT('%',#{Phone},'%')")
    List<Franchise> getFranchiseByCreditCardAndFranID(Integer FranID,Integer CreditCard,String FranName,String Phone,String Email);

    @Insert("INSERT INTO franchise (FranName,Password,FranImage,WhoInCharge,ChargeID,ChargePhone,Phone,Email,Balance,CreditCard,Introduce) VALUES(#{FranName},#{Password},#{FranImage},#{WhoInCharge},#{ChargeID},#{ChargePhone},#{Phone},#{Email},#{Balance},#{CreditCard},#{Introduce})")
    Integer addFran(Franchise franchise);

    @Select("SELECT * FROM franchise WHERE FranID=#{FranID}")
    Franchise findFranByID(Integer FranID);

    @Update("UPDATE franchise SET FranName=#{FranName},Password=#{Password},FranImage=#{FranImage},WhoInCharge=#{WhoInCharge},ChargeID=#{ChargeID},ChargePhone=#{ChargePhone},Phone=#{Phone},Email=#{Email},Balance=#{Balance},CreditCard=#{CreditCard},Introduce=#{Introduce} WHERE FranID=#{FranID}")
    Integer updateFranByID(Franchise franchise);

    @Delete("DELETE FROM franchise WHERE FranID=#{FranID}")
    Integer deleteFranByID(Integer FranID);

    //    Select
    @Select("select * from franchise where FranName=#{FranName}")
    Franchise getFranByName(String FranName);
    //    Update
    @Update("update franchise set FranName=#{FranName},Password=#{Password},WhoInCharge=#{WhoInCharge},ChargeID=#{ChargeID},ChargePhone=#{ChargePhone},Phone=#{Phone},Email=#{Email},CreditCard=#{CreditCard},Introduce=#{Introduce} where FranName=#{FranName}")
    Integer updateFran(Franchise franchise);
}
