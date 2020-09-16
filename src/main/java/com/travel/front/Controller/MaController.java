package com.travel.front.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Tourist_Backstage")
public class MaController {

    @GetMapping("/asset_manage")
    public String getPageAssetManage(){
        return "backstage_asset_manage";
    }

    @GetMapping("/comment_list")
    public String getPageCommentList(){
        return "backstage_comment_list";
    }

    @GetMapping("/index")
    public String getPageIndex(){
        return "backstage_index";
    }

    @GetMapping("/item_list")
    public String getPageItemList(){
        return "backstage_item_list";
    }

    @GetMapping("/item_examine")
    public String getPageItemExamine(){
        return "backstage_item_examine";
    }

    @GetMapping("/item_update")
    public String getPageItemUpdate(){
        return "backstage_item_update";
    }

    @GetMapping("/order_list")
    public String getPageOrderList(){
        return "backstage_order_list";
    }

    @GetMapping("/seller_list")
    public String getPageSellerList(){
        return "backstage_seller_list";
    }

    @GetMapping("/statistics")
    public String getPageStatistics(){
        return "backstage_statistics";
    }

    @GetMapping("/update_user")
    public String getPageUpdateUser(){
        return "backstage_update_user";
    }

    @GetMapping("/user_add")
    public String getPageUserAdd(){
        return "backstage_user_add";
    }

    @GetMapping("/user_list")
    public String getPageUserList(){
        return "backstage_user_list";
    }



}
