package com.travel.front.Controller;


import com.travel.front.Entity.Goods;
import com.travel.front.Entity.Login;
import com.travel.front.Entity.ScenicSpot;
import com.travel.front.Entity.User;
import com.travel.front.Service.GoodsService;
import com.travel.front.Service.LoginService;
import com.travel.front.Service.ScenicSpotService;
import com.travel.front.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("Tourist")
public class UserController {
    @Autowired
    private ScenicSpotService SSService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TouristService touristService;


    @GetMapping("/index")
    public String toIndex(Model model){
        Login loginUser = loginService.getLoginUser();
        User user = touristService.getUserByName(loginUser.getName());
        model.addAttribute("Info",user);
        List<ScenicSpot> scenicSpots=SSService.getAllSpot();
        model.addAttribute("SS",scenicSpots);
        return "index_T";
    }

    @GetMapping("/order")
    public String toOrder()
    {
        return "order_list_f";
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
    public String toSpots(Model model) {
        Login loginUser = loginService.getLoginUser();
        User user = touristService.getUserByName(loginUser.getName());
        List<ScenicSpot> scenicSpots=SSService.getAllSpot();
        model.addAttribute("Info",user);
        model.addAttribute("SS",scenicSpots);

        return "spots";
    }

    @GetMapping("/spots/{SSID}")
    public String toSpotsRecommend(@PathVariable("SSID") Integer SSID, Model model) {
        Login loginUser = loginService.getLoginUser();
        User user = touristService.getUserByName(loginUser.getName());
        ScenicSpot ss = SSService.getSpotByID(SSID);
        List<Goods> items = goodsService.getGoodsBySSID(ss);
        model.addAttribute("Info",user);
        model.addAttribute("spot",ss);
        model.addAttribute("items",items);
        return "spots-detail";
    }

    @GetMapping("/line")
    public String toLine()
    {
        return "line";
    }

}