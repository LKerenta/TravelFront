package com.travel.front.Controller;



import com.travel.front.Service.ScenicSpotService;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.*;
import com.travel.front.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("Tourist_T")
public class UserController {
    @Autowired
    private ScenicSpotService SSService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TouristService touristService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ScenicSpotService scenicSpotService;

    @GetMapping("/index")
    public String toIndex(Model model){
        Login loginUser = loginService.getLoginUser();
        User user = touristService.getUserByName(loginUser.getName());
        model.addAttribute("Info",user);
        List<ScenicSpot> scenicSpots=SSService.getAllSpot();
        model.addAttribute("SS",scenicSpots);
        return "index_T";
    }

    @RequestMapping("/order")
    public String toOrder(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                          @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,Model model)
    {
        Login login = loginService.getLoginUser();
        User user = touristService.findUserByID(login.getID());
        PageInfo<Order> orderList = orderService.findOrderByUserID(5,1,user.getUserID());
        List<String> FranNames = orderService.findFranNameByUserID(user.getUserID());
        List<String> GoodsNames = orderService.findGoodNameByUserID(user.getUserID());
        model.addAttribute("user",user);
        model.addAttribute("orderList",orderList);
        model.addAttribute("FranNames",FranNames);
        model.addAttribute("GoodsNames",GoodsNames);

        ArrayList<String> States = new ArrayList<String>();
        States.add("未付款");
        States.add("已付款");
        States.add("出行中");
        States.add("出行完毕");
        States.add("退款中");
        States.add("已退款");
        States.add("已结束");
        States.add("退款拒绝");
        model.addAttribute("States",States);

        return "order_list_t";
    }

    @GetMapping("/delete_order/{OrderID}")
    public String deleteOrder(@PathVariable("OrderID") Integer OrderID){
        Integer i = orderService.deleteOrderByID(OrderID);
        return "redirect:/Tourist_T/order";
    }

    @GetMapping("/order_details/{OrderID}")
    public String orderDetails(@PathVariable("OrderID") Integer OrderID,Model model){
        Order order = orderService.findOrderByID(OrderID);
        String GoodsName = orderService.findGoodNameByID(OrderID);
        String UserName = orderService.findUserNameByID(OrderID);
        String FranName = orderService.findFranNameByID(OrderID);

        ArrayList<String> states = new ArrayList<String>();
        states.add("未付款");
        states.add("已付款");
        states.add("出行中");
        states.add("出行完毕");
        states.add("退款中");
        states.add("已退款");
        states.add("已结束");
        states.add("退款拒绝");

        model.addAttribute("UserName",UserName);
        model.addAttribute("FranName",FranName);
        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("States",states);
        model.addAttribute("Order",order);
        return "tourist_order_details";
    }

    @GetMapping("/view_order/{GoodsID}")
    public String viewOrder(@PathVariable("GoodsID") Integer GoodsID, Model model){
        Goods goods = goodsService.getGoodsByID(GoodsID);
        String FranName = goodsService.getFranName(GoodsID);
        ScenicSpot scenicSpot = goodsService.getScenicByID(goods.getSSID());
        model.addAttribute("Goods",goods);
        model.addAttribute("FranName",FranName);
        model.addAttribute("Scenic",scenicSpot);
        return "tourist_view_order";
    }


    @PostMapping("/create_order/{GoodsID}")
    public String createOrder(@PathVariable("GoodsID") Integer GoodsID){
        Goods goods = goodsService.getGoodsByID(GoodsID);
        Login login = loginService.getLoginUser();
        User user = touristService.findUserByID(login.getID());
        Order order = new Order();
        order.setGoodsID(goods.getGoodsID());
        order.setFranID(goods.getFranID());
        order.setPrice(goods.getPrice());
        order.setUserID(user.getUserID());
        if(goods.getPrice().intValue() < user.getBalance()){
            order.setState(1);
            Integer i = touristService.payOrder(goods.getPrice(),user.getUserID());
        }else{
            order.setState(0);
        }
        Integer i = orderService.CreateOrder(order);
        return "tourist_create_order";
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