package com.travel.front.Service;


import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Entity.UserType;

public interface LoginService {
    Integer login(UserType userType);
    User RT(UserType userType);
    Franchise RF(UserType userType);
    Manager RM(UserType userType);
    Integer Registry(User user);
    Integer Registry(Franchise franchise);
    Integer Registry(Manager manager);
}
