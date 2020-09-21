package com.travel.front.ServiceImpl;

import com.travel.front.Entity.Manager;
import com.travel.front.Mapper.AdminMapper;
import com.travel.front.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Manager findManagerByID(Integer MaID) {
        return adminMapper.findManagerByID(MaID);
    }

    @Override
    public Integer updateManager(Manager manager) {
        return adminMapper.updateManager(manager);
    }
}
