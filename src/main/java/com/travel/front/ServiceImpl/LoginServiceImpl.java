package com.travel.front.ServiceImpl;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Entity.UserType;
import com.travel.front.Mapper.LoginMapper;
import com.travel.front.Service.LoginService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Integer login(UserType userType) {
        UserType loginUser = null;
        loginUser = loginMapper.login(userType);
        if(loginUser != null)  return loginUser.getType();
        return -1;
    }

    @Override
    public User RT(UserType userType) {
        return loginMapper.RT(userType);
    }

    @Override
    public Franchise RF(UserType userType) {
        return loginMapper.RF(userType);
    }

    @Override
    public Manager RM(UserType userType) {
        return loginMapper.RM(userType);
    }
}
