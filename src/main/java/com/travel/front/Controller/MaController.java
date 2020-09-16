package com.travel.front.Controller;

import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.Comment;
import com.travel.front.Service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Tourist_Backstage")
public class MaController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/asset_manage")
    public String getPageAssetManage(){
        return "backstage_asset_manage";
    }

    @RequestMapping("/comment_list")
    public String getPageCommentList(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                     @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                                     @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                                     @RequestParam(value = "UserName",defaultValue = "") String UserName, Model model){
        PageInfo<Comment> commentlist = null;
        List<String> usernamelist = null;
        List<String> goodsnamelist = null;
        if(GoodsName.isEmpty()&&UserName.isEmpty()){
            commentlist = commentService.getAllComment(PageSize,PageIndex);
            usernamelist = commentService.getUserNameList();
            goodsnamelist = commentService.getGoodsNameList();
        }else if(GoodsName.isEmpty() && !UserName.isEmpty()){
            commentlist = commentService.getCommentsByUserName(PageSize,PageIndex,UserName);
            usernamelist = commentService.getUserNameListByUserName(UserName);
            goodsnamelist = commentService.getGoodsNameListByUserName(UserName);
        }else if(!GoodsName.isEmpty() && UserName.isEmpty()){
            commentlist = commentService.getCommentsByGoodsName(PageSize,PageIndex,GoodsName);
            usernamelist = commentService.getUserNameListByGoodsName(GoodsName);
            goodsnamelist = commentService.getGoodsNameListByGoodsName(GoodsName);
        }else{
            commentlist = commentService.getCommentByGoodsNameAndUserName(PageSize,PageIndex,GoodsName,UserName);
            usernamelist = commentService.getUserNameListByGoodsNameAndUserName(GoodsName,UserName);
            goodsnamelist = commentService.getGoodsNameListByGoodsNameAndUserName(GoodsName,UserName);
        }

        model.addAttribute("comments",commentlist);
        model.addAttribute("UserNameList",usernamelist);
        model.addAttribute("GoodsNameList",goodsnamelist);

        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("UserName",UserName);
        return "backstage_comment_list";
    }

    @GetMapping("/delete_comment/{CID}")
    public String deleteComment(@PathVariable("CID") Integer CID){
        Integer i = commentService.deleteComment(CID);
        return "redirect:/Tourist_Backstage/comment_list";
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
