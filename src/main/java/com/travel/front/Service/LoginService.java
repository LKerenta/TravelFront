package com.travel.front.Service;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Entity.UserType;

public interface LoginService {
    Integer Login(UserType userType);
    User RT(UserType userType);
    Franchise RF(UserType userType);
    Manager RM(UserType userType);
}
