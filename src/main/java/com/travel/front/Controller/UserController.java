package com.travel.front.Controller;


import com.travel.front.Service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("Tourist")
public class UserController {
    @Autowired
    private ScenicSpotService SSService;


    @GetMapping("/order")
    public String toOrder()
    {
        return "order_list";
    }

    @GetMapping("/seller_list")
    public String toSellerList()
    {
        return "seller_list";
    }

    @GetMapping("/user_add")
    public String toUserAdd()
    {
        return "user_add";
    }

    @GetMapping("/spots")
    public String toSpots()
    {
        return "spots";
    }

    @GetMapping("/spots-recommend")
    public String toSpotsRecommend()
    {
        return "spots-recommend";
    }

    @GetMapping("/line")
    public String toLine()
    {
        return "line";
    }

}