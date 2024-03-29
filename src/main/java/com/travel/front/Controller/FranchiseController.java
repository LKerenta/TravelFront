package com.travel.front.Controller;


import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.*;

import com.travel.front.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("/Order")
    public String getOrdersByFran(Model model){
        Login userType = loginService.getLoginUser();
        Franchise franchise=franchiseService.findFranByID(userType.getID());
        List<Order> orders=franchiseService.getOrdersByFran(userType.getID());
        model.addAttribute("Info",franchise);
        model.addAttribute("Order",orders);
        return "order_list_f";
    }

    @GetMapping("/order/{ID}")
    public String orderDetail(@PathVariable("ID")Integer OrderID,Model model){
        Login userType = loginService.getLoginUser();
        Franchise franchise=franchiseService.findFranByID(userType.getID());
        model.addAttribute("Info",franchise);


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
        return "order_details_f";

    }

    @PostMapping("update_order")
    public String updateOrder(Order order,Model model){
        Login userType = loginService.getLoginUser();
        Franchise franchise=franchiseService.findFranByID(userType.getID());
        model.addAttribute("Info",franchise);
        Integer i = franchiseService.updateOrderState(order);
        return "redirect:/Franchise/Order";
    }

    @GetMapping("deleteOrder/{ID}")
    public String deleteOrder(@PathVariable("ID")Integer ID){
        Integer i = orderService.deleteOrderByID(ID);
        return "redirect:/Franchise/Order";
    }

    @RequestMapping("/item")
    public String getAllItem(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);
        List<Goods> items = goodsService.getGoodsByFranID(userType.getID());
        model.addAttribute("items",items);



        return "item_list_f";
    }
    @GetMapping("/item_update/{GoodsID}")
    public String updateItem(@PathVariable("GoodsID")Integer GoodsID,Model model){
        Goods goods = goodsService.getGoodsByID(GoodsID);
        ScenicSpot scenicSpot = goodsService.getScenicByID(goods.getSSID());
        String FranName = goodsService.getFranName(GoodsID);

        model.addAttribute("Goods",goods);
        model.addAttribute("Scenic",scenicSpot);
        model.addAttribute("FranName",FranName);
        Login userType = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(userType.getID());
        model.addAttribute("Info",franchise);
        return "item_update_f";
    }

    @PostMapping("/item_update")
    public String update(Goods goods,Model model){
        Login login=loginService.getLoginUser();
        Franchise franchise=franchiseService.findFranByID(login.getID());
        goodsService.updateGood(goods);
        model.addAttribute("Info",franchise);
        return "redirect:/Franchise/item";
    }

    @GetMapping("/AddItem")
    public String addItemPage(Model model){
        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        model.addAttribute("Info",franchise);
        return "item_add_f";
    }

    @PostMapping("/AddItem")
    public String addItem(Goods goods,Model model){
        goodsService.CreateGoods(goods);
        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        model.addAttribute("Info",franchise);
        return "redirect:/Franchise/item";
    }

    @GetMapping("/item_delete/{GoodsID}")
    public String deleteGoods(@PathVariable("GoodsID") Integer GoodsID, Model model){
        Integer i = goodsService.deleteGoodsByGoodsID(GoodsID);
        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        model.addAttribute("Info",franchise);
        return "redirect:/Franchise/item";
    }


    @GetMapping("/asset")
    public String Asset(Model model){
        Login userType = loginService.getLoginUser();
        model.addAttribute("Info",userType);

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
    public String ViewComment(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                              @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                              @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                              @RequestParam(value = "UserName",defaultValue = "") String UserName,
                              Model model){
        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        model.addAttribute("Info",franchise);

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
        return "comment_list_f";
    }

    @GetMapping("/comment_details/{CID}")
    public String commentDetails(@PathVariable("CID") Integer CID, Model model){
        Comment comment = commentService.findCommentByID(CID);
        String UserName = commentService.findUserNameByID(CID);
        String GoodsName = commentService.findGoodsNameByID(CID);

        Login login = loginService.getLoginUser();
        Franchise franchise = franchiseService.findFranByID(login.getID());
        model.addAttribute("Info",franchise);

        model.addAttribute("Comment",comment);
        model.addAttribute("UserName",UserName);
        model.addAttribute("GoodsName",GoodsName);

        return "comment_details_f";
    }

    @GetMapping("/delete_comment/{CID}")
    public String deleteComment(@PathVariable("CID") Integer CID){
        Integer i = commentService.deleteComment(CID);
        return "redirect:/Franchise/comment";
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
