package com.travel.front.Controller;


import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Goods;
import com.travel.front.Entity.Login;
import com.travel.front.Entity.Order;

import com.travel.front.Service.CommentService;
import com.travel.front.Service.FranchiseService;
import com.travel.front.Service.GoodsService;
import com.travel.front.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//For Franchise
@Controller
@RequestMapping("Franchise")
public class FranchiseController {
    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CommentService commentService;


    @GetMapping("/index")
    public String indexFran(Model model){
        Login login = loginService.getLoginUser();
        List<Goods> items = goodsService.getGoodsByFranID(login.getID());
        List<Order> orders = franchiseService.getOrdersByFran(login.getID());
        model.addAttribute("Info",login);
        model.addAttribute("items",items);
        model.addAttribute("orders",orders);
        return "index_F";
    }

    @GetMapping("/Order")
    public String getOrdersByFran(Model model){
        Login userType = loginService.getLoginUser();
        List<Order> orders=franchiseService.getOrdersByFran(userType.getID());
        model.addAttribute("Info",userType);
        model.addAttribute("Order",orders);
        return "order_list_f";
    }

    @GetMapping("/item")
    public String getAllItem(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        List<Goods> items = goodsService.getGoodsByFranID(userType.getID());
        model.addAttribute("items",items);
        return "item_list_f";
    }
    @GetMapping("/updateItem")
    public String updateItem(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        return "item_update_f";
    }

    @GetMapping("/AddItem")
    public String addItemPage(Model model){
        Login login = loginService.getLoginUser();
        model.addAttribute("Info",login);
        return "item_add_f";
    }

    @PostMapping("/AddItem")
    public String addItem(Goods goods,Model model){
        Login login=loginService.getLoginUser();
        goodsService.CreateGoods(goods);
        model.addAttribute("Info",login);
        return "redirect:item";
    }


    @GetMapping("/asset")
    public String Asset(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        return "asset_manage_f";
    }

    @GetMapping("/statistics")
    public String Stat(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        return "statistics_f";
    }

    @GetMapping("/comment")
    public String ViewComment(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        return "comment_list_f";
    }
    @GetMapping("/profile")
    public String UpdateProfile(Model model){
        Login userType = loginService.getLoginUser();
        Franchise franchise = franchiseService.getFranByName(userType.getName());
        model.addAttribute("Info",franchise);
        return "update_franchise";
    }
    @PostMapping("/updateProfile")
    public String update(Franchise franchise){
        Integer i = franchiseService.updateFranInfo(franchise);
        return "redirect:/index";
    }
}
