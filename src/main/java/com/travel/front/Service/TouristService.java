package com.travel.front.Service;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.User;

import java.util.List;

public interface TouristService {
    PageInfo<User> getAllUser(Integer PageSize,Integer PageIndex);
    PageInfo<User> getUsersByNoQQNumberAndUserID(Integer PageSize,Integer PageIndex,String UserName,String TrueName,String IDNumber,String Email,String Phone);
    PageInfo<User> getUsersByUserID(Integer PageSize,Integer PageIndex,Integer UserID,String UserName,String TrueName,String IDNumber,String Email,String Phone);
    PageInfo<User> getUsersByQQNumber(Integer PageSize,Integer PageIndex,Integer QQNumber,String UserName,String TrueName,String IDNumber,String Email,String Phone);
    PageInfo<User> getUsersByUserIDAndQQNumber(Integer PageSize,Integer PageIndex,Integer UserID,Integer QQNumber,String UserName,String TrueName,String IDNumber,String Email,String Phone);

    Integer addUser(User user);
    User findUserByID(Integer UserID);
    Integer updateUserByID(User user);
    List<User> getAllUser();
    Integer deleteUserByID(Integer UserID);
}
