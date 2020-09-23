package com.travel.front.Controller;


import com.travel.front.Entity.*;

import com.travel.front.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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

    @Autowired
    private OrderService orderService;

    @Autowired
    private TouristService touristService;



    @GetMapping("/index")
    public String indexFran(Model model){
        List<User> userList = touristService.getAllUser();
        Login login = loginService.getLoginUser();
        List<Goods> items = goodsService.getGoodsByFranID(login.getID());
        List<Order> orders = franchiseService.getOrdersByFran(login.getID());
        Integer userNumber = userList.size();

//        Comment
        List<Comment> commentList = commentService.getAllComments();
        ArrayList<Comment> newCommentList = new ArrayList<Comment>();
        List<String> userNameList = commentService.getUserNameList();
        ArrayList<String> userNameC = new ArrayList<String>();
        Integer size = commentList.size();
        if(size >=5){
            for(int i = 0;i<5;i++){
                Comment comment = commentList.get(size -1 - i);
                String userC = userNameList.get(size - 1 - i);
                userNameC.add(userC);
                newCommentList.add(comment);
            }
        }

        List<Goods> goodsList = goodsService.getAllGoods();
        ArrayList<Goods> newGoodsList = new ArrayList<Goods>();
        List<String> franNameList = goodsService.getAllFranName();
        ArrayList<String> franNameG = new ArrayList<String>();
        Integer sizeG = goodsList.size();
        if(sizeG >=5){
            for(int i = 0;i<5;i++){
                Goods goods = goodsList.get(sizeG -1 - i);
                String franG = franNameList.get(sizeG - 1 - i);
                franNameG.add(franG);
                newGoodsList.add(goods);
            }
        }

        List<Order> orderList = orderService.getAllOrder();
        ArrayList<Order> newOrdersList = new ArrayList<Order>();
        List<String> userNameListO = orderService.getAllUserName();
        ArrayList<String> userO = new ArrayList<String>();
        List<String> goodsListO = orderService.getAllGoodName();
        ArrayList<String> goodsO = new ArrayList<String>();
        Integer sizeO = orderList.size();
        if(sizeO >=5){
            for(int i = 0;i<5;i++){
                Order order = orderList.get(sizeO -1 - i);
                String user = userNameListO.get(sizeO -1 -i);
                String good = goodsListO.get(sizeO -1 -i);
                goodsO.add(good);
                userO.add(user);
                newOrdersList.add(order);
            }
        }

        Integer income = 0;
        for(int i = 0;i<sizeO;i++){
            Order order = orderList.get(i);
            if(order.getState() != 0)
                income += order.getPrice();
        }
        model.addAttribute("Income",income);

        if(size >= 5) {
            model.addAttribute("newComments", newCommentList);
            model.addAttribute("userNameC",userNameC);
        }else{
            model.addAttribute("newComments",commentList);
            model.addAttribute("userNameC",userNameList);
        }

        if(sizeG >= 5) {
            model.addAttribute("newGoods", newGoodsList);
            model.addAttribute("franNameG",franNameG);
        }else{
            model.addAttribute("newGoods",goodsList);
            model.addAttribute("franNameG",franNameList);
        }

        if(sizeO >= 5) {
            model.addAttribute("newOrders", newOrdersList);
            model.addAttribute("userNameO",userO);
            model.addAttribute("goodsNameO",goodsO);
        }else{
            model.addAttribute("newOrders",orderList);
            model.addAttribute("userNameO",userNameListO);
            model.addAttribute("goodsNameO",goodsListO);
        }

        Integer OrderNumber = orderList.size();
        model.addAttribute("orderNumber",OrderNumber);
        Integer GoodsNumber = goodsList.size();
        model.addAttribute("goodsNumber",GoodsNumber);
        model.addAttribute("UserNumber",userNumber);

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
        return "redirect:/Franchise/item";
    }


    @GetMapping("/asset")
    public String Asset(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        return "asset_manage_f";
    }

    @GetMapping("/statistics")
    public String getPageStatistics(Model model){
        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        List<Order> orders = orderService.getAllOrder();
        Integer allOrder = orders.size();

        List<Goods> passGoods = goodsService.getAllGoods();
        List<Goods> examineGoods = goodsService.getAllExamineGoods();
        List<Goods> notPassGoods = goodsService.getAllNotPassGoods();

        List<Order> ordersEnd = orderService.getAllDoneOrder();
        List<Order> ordersDraw = orderService.getDrawBackDoneOrders();
        List<Order> orderNotEnd = orderService.getNotEndOrders();

        List<Comment> allComment = commentService.getAllComments();
        List<Goods> allGoods = goodsService.allGoods();

        Calendar cal = Calendar.getInstance();
        Integer day = cal.get(Calendar.DATE);
        Integer month = cal.get(Calendar.MONTH)+1;
        Integer year = cal.get(Calendar.YEAR);

        int[] dayOrdersList = new int[32];
        for(int i = 0;i<32;i++){
            dayOrdersList[i] = 0;
        }

        int[] dayInComeList = new int[32];
        for(int i = 0;i<32;i++){
            dayInComeList[i] = 0;
        }

        Integer lastMonthOrders = 0;
        Integer lastMonthInCome = 0;
        ArrayList<Integer> timeList = new ArrayList<Integer>();
        for(int i = 0;i<allOrder;i++) {
            Date date = orders.get(i).getDate();
            if (date != null) {
                timeList = splitDate(date);
                dayOrdersList[timeList.get(2).intValue()] += 1;
                dayInComeList[timeList.get(2).intValue()] += orders.get(i).getPrice();
                if (timeList.get(0).equals(year) && timeList.get(1).equals(month - 1)) {
                    lastMonthOrders += 1;
                    lastMonthInCome += orders.get(i).getPrice();
                }
            }
        }


        Integer sum = 0;
        for(int i = 0;i<orders.size();i++){
            sum += orders.get(i).getPrice();
        }



        model.addAttribute("Info",franchise);
        model.addAttribute("AllOrders",allOrder);
        model.addAttribute("notPass",notPassGoods.size());
        model.addAttribute("Pass",passGoods.size());
        model.addAttribute("Examine",examineGoods.size());
        model.addAttribute("orderEnd",ordersEnd.size());
        model.addAttribute("orderNotEnd",orderNotEnd.size());
        model.addAttribute("orderDraw",ordersDraw.size());
        model.addAttribute("comments",allComment.size());
        model.addAttribute("allGoods",allGoods.size());
        model.addAttribute("lastMonthOrders",lastMonthOrders);
        model.addAttribute("dayOrdersList",dayOrdersList);
        model.addAttribute("AllInCome",sum);
        model.addAttribute("dayInComeList",dayInComeList);
        model.addAttribute("lastMonthInCome",lastMonthInCome);
        return "statistics_f";
    }

    @GetMapping("/comment")
    public String ViewComment(Model model){
        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        model.addAttribute("Info",franchise);
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

    public ArrayList<Integer> splitDate(Date date){
        String dateString = date.toString();
        String[] dateList = dateString.split("-",3);
        ArrayList<Integer> dateTime = new ArrayList<Integer>();
        for(int i = 0;i<3;i++){
            dateTime.add(Integer.parseInt(dateList[i]));
        }
        return dateTime;
    }
}
