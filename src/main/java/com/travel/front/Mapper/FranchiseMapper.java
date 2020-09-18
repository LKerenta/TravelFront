package com.travel.front.Mapper;

import com.travel.front.Entity.Franchise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

}
