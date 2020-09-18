package com.travel.front.Controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.*;
import com.travel.front.Service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.IDN;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("Tourist_Backstage")
public class MaController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TouristService touristService;

    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/asset_manage")
    public String getPageAssetManage(){
        return "backstage_asset_manage";
    }

    @RequestMapping("/comment_list")
    public String getPageCommentList(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                     @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                                     @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                                     @RequestParam(value = "UserName",defaultValue = "") String UserName,
                                     Model model){
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

    @RequestMapping("/item_list")
    public String getPageItemList(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                  @RequestParam(value = "PageIndex",defaultValue = "1")Integer PageIndex,
                                  @RequestParam(value = "GoodID",defaultValue = "") Integer GoodID,
                                  @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                                  @RequestParam(value = "FranName",defaultValue = "") String FranName,
                                  @RequestParam(value = "Price",defaultValue = "") Integer Price,
                                  Model model){
        PageInfo<Goods> goodsList = null;
        List<String> franNameList = null;
        if(GoodsName.isEmpty() && FranName.isEmpty() && Price == null && GoodID == null){
            goodsList = goodsService.getAllGoods(PageSize,PageIndex);
            franNameList = goodsService.getAllFranName();
        }else if(!GoodsName.isEmpty() && FranName.isEmpty() && Price == null && GoodID == null){
            goodsList = goodsService.getGoodsByGoodName(PageSize,PageIndex,GoodsName);
            franNameList = goodsService.getAllFranNameByGoodName(GoodsName);
        }else if(GoodsName.isEmpty() && !FranName.isEmpty() && Price==null && GoodID == null){
            goodsList = goodsService.getGoodsByFranName(PageSize,PageIndex,FranName);
            franNameList = goodsService.getAllFranNameByFranName(FranName);
        }else if(GoodsName.isEmpty() && FranName.isEmpty() && Price != null && GoodID == null){
            goodsList = goodsService.getGoodsByPrice(PageSize,PageIndex,Price);
            franNameList = goodsService.getAllFranNameByPrice(Price);
        }else if(GoodsName.isEmpty() && FranName.isEmpty() && Price == null && GoodID != null){
            goodsList = goodsService.getGoodsByGoodID(PageSize,PageIndex,GoodID);
            franNameList = goodsService.getAllFranNameByGoodID(GoodID);
        }else if(!GoodsName.isEmpty() && !FranName.isEmpty() && Price == null && GoodID == null){
            goodsList = goodsService.getGoodsByFranNameAndGoodsName(PageSize,PageIndex,GoodsName,FranName);
            franNameList = goodsService.getAllFranNameByFranNameAndGoodsName(GoodsName,FranName);
        }else if(!GoodsName.isEmpty() && FranName.isEmpty() && Price != null && GoodID == null){
            goodsList = goodsService.getAllGoodsByPriceAndGoodsName(PageSize,PageIndex,GoodsName,Price);
            franNameList = goodsService.getAllFranNameByPriceAndGoodsName(GoodsName,Price);
        }else if(!GoodsName.isEmpty() && FranName.isEmpty() && Price == null && GoodID != null){
            goodsList = goodsService.getAllGoodsByGoodsIDAndGoodsName(PageSize,PageIndex,GoodsName,GoodID);
            franNameList = goodsService.getAllFranNameByGoodsIDAndGoodsName(GoodsName,GoodID);
        }else if(GoodsName.isEmpty() && !FranName.isEmpty() && Price != null && GoodID == null){
            goodsList = goodsService.getAllGoodsByPriceAndFranName(PageSize,PageIndex,FranName,Price);
            franNameList = goodsService.getAllFranNameByPriceAndFranName(FranName,Price);
        }else if(GoodsName.isEmpty() && !FranName.isEmpty() && Price == null && GoodID != null){
            goodsList = goodsService.getAllGoodsByGoodsIDAndFranName(PageSize,PageIndex,FranName,GoodID);
            franNameList = goodsService.getAllFranNameByGoodsIDAndFranName(FranName,GoodID);
        }else if(GoodsName.isEmpty() && FranName.isEmpty() && Price != null && GoodID != null){
            goodsList = goodsService.getAllGoodsByGoodsIDAndPrice(PageSize,PageIndex,Price,GoodID);
            franNameList = goodsService.getAllFranNameByGoodsIDAndPrice(Price,GoodID);
        }else if(!GoodsName.isEmpty() && !FranName.isEmpty() && Price != null && GoodID == null){
            goodsList = goodsService.getAllGoodsByGoodsNameAndFranNameAndPrice(PageSize,PageIndex,Price,GoodsName,FranName);
            franNameList = goodsService.getAllFranNameByGoodsNameAndFranNameAndPrice(Price,GoodsName,FranName);
        }else if(!GoodsName.isEmpty() && !FranName.isEmpty() && Price == null && GoodID != null){
            goodsList = goodsService.getAllGoodsByGoodsNameAndFranNameAndGoodsID(PageSize,PageIndex,GoodID,GoodsName,FranName);
            franNameList = goodsService.getAllFranNameByGoodsNameAndFranNameAndGoodsID(GoodID,GoodsName,FranName);
        }else if(GoodsName.isEmpty() && !FranName.isEmpty() && Price != null && GoodID != null){
            goodsList = goodsService.getAllGoodsByGoodsIDAndFranNameAndPrice(PageSize,PageIndex,Price,GoodID,FranName);
            franNameList = goodsService.getAllFranNameByGoodsIDAndFranNameAndPrice(Price,GoodID,FranName);
        }else if(!GoodsName.isEmpty() && FranName.isEmpty() && Price != null && GoodID != null){
            goodsList = goodsService.getAllGoodsByGoodsNameAndGoodsIDAndPrice(PageSize,PageIndex,Price,GoodsName,GoodID);
            franNameList = goodsService.getAllFranNameByGoodsNameAndGoodsIDAndPrice(Price,GoodsName,GoodID);
        }else{
            goodsList = goodsService.getAllGoodsByGoodsNameAndGoodsIDAndPriceAndFranName(PageSize,PageIndex,FranName,Price,GoodsName,GoodID);
            franNameList = goodsService.getAllFranNameByGoodsNameAndGoodsIDAndPriceAndFranName(FranName,Price,GoodsName,GoodID);
        }

        model.addAttribute("Goods",goodsList);
        model.addAttribute("FranNames",franNameList);

        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("FranName",FranName);
        model.addAttribute("Price",Price);
        model.addAttribute("GoodID",GoodID);
        return "backstage_item_list";
    }

    @GetMapping("/delete_good/{GoodsID}")
    public String deleteGoods(@PathVariable("GoodsID") Integer GoodsID){
        Integer i = goodsService.deleteGoodsByGoodsID(GoodsID);
        return "redirect:/Tourist_Backstage/item_list";
    }

    @RequestMapping("/item_examine")
    public String getPageItemExamine(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                     @RequestParam(value = "PageIndex",defaultValue = "1")Integer PageIndex,
                                     @RequestParam(value = "GoodID",defaultValue = "") Integer GoodID,
                                     @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                                     @RequestParam(value = "FranName",defaultValue = "") String FranName,
                                     @RequestParam(value = "Price",defaultValue = "") Integer Price,
                                     Model model){
        PageInfo<Goods> goodsList = null;
        List<String> franList = null;
        if(GoodID == null && Price == null && GoodsName.isEmpty() && FranName.isEmpty()){
            goodsList = goodsService.getAllExamineGoods(PageSize,PageIndex);
            franList = goodsService.getAllExamineFranName();
        }else if(GoodID == null && Price == null){

        }else if(GoodID != null && Price == null){

        }else if(GoodID == null && Price != null){

        }else{

        }

        model.addAttribute("Goods",goodsList);
        model.addAttribute("Frans",franList);

        model.addAttribute("GoodsID",GoodID);
        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("FranName",FranName);
        model.addAttribute("Price",Price);
        return "backstage_item_examine";
    }

    @GetMapping("/item_update")
    public String getPageItemUpdate(){
        return "backstage_item_update";
    }

    @RequestMapping("/order_list")
    public String getPageOrderList(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                   @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                                   @RequestParam(value = "OrderID",defaultValue = "") Integer OrderID,
                                   @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                                   @RequestParam(value = "UserName",defaultValue = "") String UserName,
                                   @RequestParam(value = "State",defaultValue = "") Integer State,
                                   @RequestParam(value = "FranName",defaultValue = "") String FranName,
                                   Model model){
        PageInfo<Order> orderList = null;
        List<String> goodsNameList = null;
        List<String> userNameList = null;
        List<String> franNameList = null;
        ArrayList<String> States = new ArrayList<String>();
        States.add("未付款");
        States.add("已付款");
        States.add("出行中");
        States.add("出行完毕");
        if(OrderID == null && State == null && UserName.isEmpty() && GoodsName.isEmpty() && FranName.isEmpty()){
            orderList = orderService.getAllOrder(PageSize,PageIndex);
            goodsNameList = orderService.getAllGoodName();
            userNameList = orderService.getAllUserName();
            franNameList = orderService.getAllFranName();
        }else if(OrderID == null && State == null){
            orderList = orderService.getAllOrderByNoStateAndOrderID(PageSize,PageIndex,UserName,GoodsName,FranName);
            goodsNameList = orderService.getAllGoodNameByNoStateAndOrderID(UserName,GoodsName,FranName);
            userNameList = orderService.getAllUserNameByNoStateAndOrderID(UserName,GoodsName,FranName);
            franNameList = orderService.getAllFranNameByNoStateAndOrderID(UserName,GoodsName,FranName);
        }else if(OrderID != null && State == null){
            orderList = orderService.getAllOrderByOrderID(PageSize,PageIndex,OrderID,UserName,GoodsName,FranName);
            goodsNameList = orderService.getAllGoodNameByOrderID(OrderID,UserName,GoodsName,FranName);
            userNameList = orderService.getAllUserNameByOrderID(OrderID,UserName,GoodsName,FranName);
            franNameList = orderService.getAllFranNameByOrderID(OrderID,UserName,GoodsName,FranName);
        }else if(OrderID == null && State != null){

        }else{

        }

        model.addAttribute("Orders",orderList);
        model.addAttribute("Users",userNameList);
        model.addAttribute("Goods",goodsNameList);
        model.addAttribute("Frans",franNameList);

        model.addAttribute("OrderID",OrderID);
        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("UserName",UserName);
        model.addAttribute("State",State);
        model.addAttribute("FranName",FranName);
        model.addAttribute("States",States);

        return "backstage_order_list";
    }

    @RequestMapping("/seller_list")
    public String getPageSellerList(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                    @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                                    @RequestParam(value = "FranID",defaultValue = "") Integer FranID,
                                    @RequestParam(value = "FranName",defaultValue = "") String FranName,
                                    @RequestParam(value = "Phone",defaultValue = "") String Phone,
                                    @RequestParam(value = "Email",defaultValue = "") String Email,
                                    @RequestParam(value = "CreditCard",defaultValue = "") Integer CreditCard,
                                    Model model){
        PageInfo<Franchise> franList = null;
        if(FranID == null && FranName.isEmpty() && Phone.isEmpty() && Email.isEmpty() && CreditCard == null){
            franList = franchiseService.getAllFranchise(PageSize,PageIndex);
        }else if(FranID == null && CreditCard == null){
            franList = franchiseService.getFranchiseByNoFranIDAndCreditCard(PageSize,PageIndex,FranName,Phone,Email);
        }else if(FranID != null && CreditCard == null){
            franList = franchiseService.getFranchiseByFranID(PageSize,PageIndex,FranID,FranName,Phone,Email);
        }else if(FranID == null && CreditCard != null){
            franList = franchiseService.getFranchiseByCreditCard(PageSize,PageIndex,CreditCard,FranName,Phone,Email);
        }else{
            franList = franchiseService.getFranchiseByCreditCardAndFranID(PageSize,PageIndex,FranID,CreditCard,FranName,Phone,Email);
        }

        model.addAttribute("Frans",franList);

        model.addAttribute("FranID",FranID);
        model.addAttribute("FranName",FranName);
        model.addAttribute("Phone",Phone);
        model.addAttribute("Email",Email);
        model.addAttribute("CreditCard",CreditCard);
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

    @RequestMapping("/user_list")
    public String getPageUserList(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                  @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                                  @RequestParam(value = "UserName",defaultValue = "") String UserName,
                                  @RequestParam(value = "UserID",defaultValue = "") Integer UserID,
                                  @RequestParam(value = "IDNumber",defaultValue = "") String IDNumber,
                                  @RequestParam(value = "TrueName",defaultValue = "") String TrueName,
                                  @RequestParam(value = "QQNumber",defaultValue = "") Integer QQNumber,
                                  @RequestParam(value = "Email",defaultValue = "") String Email,
                                  @RequestParam(value = "Phone",defaultValue = "") String Phone,
                                  Model model){
        PageInfo<User> userList = null;
        if(UserID ==null && UserName.isEmpty() && IDNumber.isEmpty() && TrueName.isEmpty() && QQNumber==null && Email.isEmpty() && Phone.isEmpty()){
            userList = touristService.getAllUser(PageSize,PageIndex);
        }else if(QQNumber == null && UserID ==null){
            userList = touristService.getUsersByNoQQNumberAndUserID(PageSize,PageIndex,UserName,TrueName,IDNumber,Email,Phone);
        }else if(QQNumber != null && UserID == null){
            userList = touristService.getUsersByQQNumber(PageSize,PageIndex,QQNumber,UserName,TrueName,IDNumber,Email,Phone);
        }else if(QQNumber == null && UserID != null){
            userList = touristService.getUsersByUserID(PageSize,PageIndex,UserID,UserName,TrueName,IDNumber,Email,Phone);
        }else{
            userList = touristService.getUsersByUserIDAndQQNumber(PageSize,PageIndex,UserID,QQNumber,UserName,TrueName,IDNumber,Email,Phone);
        }

        model.addAttribute("Users",userList);

        model.addAttribute("UserName", UserName);
        model.addAttribute("UserID",UserID);
        model.addAttribute("IDNumber", IDNumber);
        model.addAttribute("TrueName",TrueName);
        model.addAttribute("QQNumber",QQNumber);
        model.addAttribute("Email",Email);
        model.addAttribute("Phone",Phone);
        return "backstage_user_list";
    }

}
