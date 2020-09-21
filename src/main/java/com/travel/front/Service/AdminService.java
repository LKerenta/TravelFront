package com.travel.front.Service;


import com.travel.front.Entity.Manager;

public interface AdminService {
    Manager findManagerByID(Integer MaID);
    Integer updateManager(Manager manager);
}
