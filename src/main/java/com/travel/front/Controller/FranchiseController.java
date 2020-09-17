package com.travel.front.Controller;


import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Order;
import com.travel.front.Service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//For Franchise
@Controller
@RequestMapping("Franchise")
public class FranchiseController {
    @Autowired
    private FranchiseService franchiseService;


    @GetMapping("/index")
    public String indexFran(){
        return "index_F";
    }

    @GetMapping("/Order")
    public String getOrdersByFran(Model model){
        Franchise franchise = new Franchise();
        franchise.setFranID(104);
        List<Order> orders=franchiseService.getOrdersByFran(franchise);
        model.addAttribute("Order",orders);
        return "order_list_f";
    }

    @GetMapping("/item")
    public String getAllItem(Model model){


        return "item_list_f";
    }
    @GetMapping("/updateItem")
    public String updateItem(){
        return "item_update_f";
    }


    @GetMapping("/asset")
    public String Asset(){
        return "asset_manage_f";
    }

    @GetMapping("/statistics")
    public String Stat(){
        return "statistics_f";
    }

    @GetMapping("/comment")
    public String ViewComment(){
        return "comment_list_f";
    }
}
