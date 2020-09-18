package com.travel.front.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.User;
import com.travel.front.Mapper.TouristMapper;
import com.travel.front.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristServiceImpl  implements TouristService {

    @Autowired
    private TouristMapper touristMapper;

    @Override
    public PageInfo<User> getAllUser(Integer PageSize, Integer PageIndex) {
        PageHelper.startPage(PageIndex,PageSize);
        List<User> users = touristMapper.getAllUser();
        PageInfo<User> list = new PageInfo<User>(users);
        return list;
    }

    @Override
    public PageInfo<User> getUsersByNoQQNumberAndUserID(Integer PageSize, Integer PageIndex, String UserName, String TrueName, String IDNumber, String Email, String Phone) {
        PageHelper.startPage(PageIndex,PageSize);
        List<User> users = touristMapper.getUsersByNoQQNumberAndUserID(UserName,TrueName,IDNumber,Email,Phone);
        PageInfo<User> list = new PageInfo<User>(users);
        return list;
    }

    @Override
    public PageInfo<User> getUsersByUserID(Integer PageSize, Integer PageIndex, Integer UserID, String UserName, String TrueName, String IDNumber, String Email, String Phone) {
        PageHelper.startPage(PageIndex,PageSize);
        List<User> users = touristMapper.getUsersByUserID(UserID,UserName,TrueName,IDNumber,Email,Phone);
        PageInfo<User> list = new PageInfo<User>(users);
        return list;
    }

    @Override
    public PageInfo<User> getUsersByQQNumber(Integer PageSize, Integer PageIndex, Integer QQNumber, String UserName, String TrueName, String IDNumber, String Email, String Phone) {
        PageHelper.startPage(PageIndex,PageSize);
        List<User> users = touristMapper.getUsersByQQNumber(QQNumber,UserName,TrueName,IDNumber,Email,Phone);
        PageInfo<User> list = new PageInfo<User>(users);
        return list;
    }

    @Override
    public PageInfo<User> getUsersByUserIDAndQQNumber(Integer PageSize, Integer PageIndex, Integer UserID, Integer QQNumber, String UserName, String TrueName, String IDNumber, String Email, String Phone) {
        PageHelper.startPage(PageIndex,PageSize);
        List<User> users = touristMapper.getUsersByUserIDAndQQNumber(UserID,QQNumber,UserName,TrueName,IDNumber,Email,Phone);
        PageInfo<User> list = new PageInfo<User>(users);
        return list;
    }
}
