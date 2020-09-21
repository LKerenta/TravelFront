package com.travel.front.Service;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Franchise;

import java.util.List;

public interface FranchiseService {
    PageInfo<Franchise> getAllFranchise(Integer PageSize,Integer PageIndex);
    PageInfo<Franchise> getFranchiseByNoFranIDAndCreditCard(Integer PageSize,Integer PageIndex,String FranName, String Phone, String Email);
    PageInfo<Franchise> getFranchiseByFranID(Integer PageSize,Integer PageIndex,Integer FranID,String FranName,String Phone,String Email);
    PageInfo<Franchise> getFranchiseByCreditCard(Integer PageSize,Integer PageIndex,Integer CreditCard,String FranName,String Phone,String Email);
    PageInfo<Franchise> getFranchiseByCreditCardAndFranID(Integer PageSize,Integer PageIndex,Integer FranID,Integer CreditCard,String FranName,String Phone,String Email);

    Integer addFran(Franchise franchise);
    Franchise findFranByID(Integer FranID);
    Integer updateFranByID(Franchise franchise);
    Integer deleteFranByID(Integer FranID);
}
