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

    @Override
    public Integer Registry(User user) {
        return null;
    }

    @Override
    public Integer Registry(Franchise franchise) {
        loginMapper.Registry(franchise);
        Integer ID = loginMapper.getNewIDFran(franchise.getFranName());
        UserType userType = new UserType();
        userType.setID(ID);
        userType.setPassword(franchise.getPassword());
        userType.setType(1);
        return loginMapper.userTypeInsert(userType);
    }

    @Override
    public Integer Registry(Manager manager) {
        return null;
    }


}
