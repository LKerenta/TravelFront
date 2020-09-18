package com.travel.front.Service;


import com.travel.front.Entity.*;

public interface LoginService {
    Integer login(UserType userType);
    User RT(UserType userType);
    Franchise RF(UserType userType);
    Manager RM(UserType userType);
    Integer Registry(User user);
    Integer Registry(Franchise franchise);
    Integer Registry(Manager manager);
    Login getLoginUser();
    Integer logOut();
}
