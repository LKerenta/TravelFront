package com.travel.front.ServiceImpl;

import com.travel.front.Entity.*;
import com.travel.front.Mapper.LoginMapper;
import com.travel.front.Service.LoginService;
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
        User user = loginMapper.RT(userType);
        loginMapper.loginStatus(user,2);
        return user;
    }

    @Override
    public Franchise RF(UserType userType) {
        Franchise franchise = loginMapper.RF(userType);
        User user = new User();
        user.setUserID(franchise.getFranID());
        user.setUserName(franchise.getFranName());
        loginMapper.loginStatus(user,1);
        return franchise;
    }

    @Override
    public Manager RM(UserType userType) {
        Manager manager = loginMapper.RM(userType);
        User user = new User();
        user.setUserID(manager.getMaID());
        user.setUserName(manager.getMaName());
        loginMapper.loginStatus(user,0);
        return manager;
    }

    @Override
    public Integer Registry(User user) {
        loginMapper.RegistryU(user);
        Integer ID = loginMapper.getNewUserID(user.getUserName());
        UserType userType = new UserType();
        userType.setID(ID);
        userType.setPassword(user.getPassword());
        userType.setType(2);
        return loginMapper.userTypeInsert(userType);
    }

    @Override
    public Integer Registry(Franchise franchise) {
        loginMapper.RegistryF(franchise);
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

    @Override
    public Login getLoginUser() {
        return loginMapper.getLoginUser();
    }

    @Override
    public Integer logOut() {
        return loginMapper.LogOut();
    }


}
