package com.travel.front.ServiceImpl;

import com.travel.front.Entity.ScenicSpot;
import com.travel.front.Mapper.ScenicSpotMapper;
import com.travel.front.Service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicSpotServiceImpl implements ScenicSpotService {
    @Autowired
    private ScenicSpotMapper ssMapper;

    @Override
    public List<ScenicSpot> SearchByName(String name) {
        return ssMapper.getSSSortedByName(name);
    }

    @Override
    public List<ScenicSpot> SearchByBrief(String brief) {
        return ssMapper.getSSSortedByBrief(brief);
    }


}
