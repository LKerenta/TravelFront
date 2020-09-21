package com.travel.front.Controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.front.Entity.*;
import com.travel.front.Service.*;
import com.travel.front.utils.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.PrinterGraphics;
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

    @Autowired
    private AdminService adminService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/asset_manage")
    public String getPageAssetManage(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                     @RequestParam(value = "PageIndex",defaultValue = "1") Integer PageIndex,
                                     @RequestParam(value = "PageIndex1",defaultValue = "1") Integer PageIndex1,
                                     Model model){
        PageInfo<Order> orderList = orderService.getOrdersDrawBack(PageSize,PageIndex);
        List<String> UserList = orderService.getUsersDrawBack();
        List<String> FranList = orderService.getFransDrawBack();
        List<String> GoodsList = orderService.getGoodsDrawBack();
        ArrayList<String> States = new ArrayList<String>();

        States.add("未付款");
        States.add("已付款");
        States.add("出行中");
        States.add("出行完毕");
        States.add("退款中");
        States.add("已退款");
        States.add("已结束");
        States.add("退款拒绝");

        PageInfo<Order> payOrderList = orderService.getOrdersWaitForPay(PageSize,PageIndex1);
        List<String> payUserList = orderService.getUsersWaitForPay();
        List<String> payFranList = orderService.getFransWaitForPay();
        List<String> payGoodsList = orderService.getGoodsWaitForPay();
        List<Order> allOrder = orderService.getAllOrder();



        Integer sum = 0;
        for(int i = 0;i<allOrder.size();i++){
            sum += allOrder.get(i).getPrice();
        }

        Integer profit = 0;
        List<Order> doneOrderList = orderService.getAllDoneOrder();
        for(int i = 0;i<doneOrderList.size();i++){
            profit += doneOrderList.get(i).getPrice();
        }

        model.addAttribute("Orders",orderList);
        model.addAttribute("Users",UserList);
        model.addAttribute("Frans",FranList);
        model.addAttribute("Goods",GoodsList);
        model.addAttribute("States",States);
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);

        model.addAttribute("OrdersP",payOrderList);
        model.addAttribute("UsersP",payUserList);
        model.addAttribute("FransP",payFranList);
        model.addAttribute("GoodsP",payGoodsList);
        model.addAttribute("turnOver",sum);
        model.addAttribute("profit",profit);
        return "backstage_asset_manage";
    }

    @GetMapping("/payToFran/{OrderID}/{MaID}")
    public String payToFranOrder(@PathVariable("OrderID") Integer OrderID,
                                 @PathVariable("MaID") Integer MaID){
        Order order = orderService.findOrderByID(OrderID);
        Integer i = orderService.payToFran(order,MaID);
        return "redirect:/Tourist_Backstage/asset_manage";
    }

    @GetMapping("/drawback/{OrderID}/{Action}")
    public String drawbackOrders(@PathVariable("OrderID") Integer OrderID,
                                 @PathVariable("Action") Integer Action){
        Order order = orderService.findOrderByID(OrderID);
        if(Action == 0){
            Integer i = orderService.drawBackByID(order);
        }else{
            Integer i = orderService.rejectDrawBackByID(OrderID);
        }
        return "redirect:/Tourist_Backstage/asset_manage";
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

        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("UserName",UserName);
        return "backstage_comment_list";
    }

    @GetMapping("/comment_details/{CID}")
    public String commentDetails(@PathVariable("CID") Integer CID,Model model){
        Comment comment = commentService.findCommentByID(CID);
        String UserName = commentService.findUserNameByID(CID);
        String GoodsName = commentService.findGoodsNameByID(CID);

        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);

        model.addAttribute("Comment",comment);
        model.addAttribute("UserName",UserName);
        model.addAttribute("GoodsName",GoodsName);

        return "backstage_comment_details";
    }

    @GetMapping("/delete_comment/{CID}")
    public String deleteComment(@PathVariable("CID") Integer CID){
        Integer i = commentService.deleteComment(CID);
        return "redirect:/Tourist_Backstage/comment_list";
    }

    @GetMapping("/manager_info")
    public String getPageManagerInfo(Model model){
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_manager_info";
    }

    @PostMapping("/update_manager")
    public String updateManager(Manager manager,@RequestParam("filePic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis() + fileName;

        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        manager.setMaImage(fileName);

        Integer i= adminService.updateManager(manager);
        return "redirect:/Tourist_Backstage/seller_list";
    }

    @GetMapping("/index")
    public String getPageIndex(Model model){
        List<User> userList = touristService.getAllUser();
        Integer userNumber = userList.size();

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
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
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
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_item_list";
    }

    @GetMapping("/delete_good/{GoodsID}")
    public String deleteGoods(@PathVariable("GoodsID") Integer GoodsID){
        Integer i = goodsService.deleteGoodsByGoodsID(GoodsID);
        return "redirect:/Tourist_Backstage/item_list";
    }

    @GetMapping("/pass_examine/{GoodsID}")
    public String passGoodsExamine(@PathVariable("GoodsID") Integer GoodsID){
        Integer i = goodsService.passExamine(GoodsID);
        return "redirect:/Tourist_Backstage/item_examine";
    }

    @GetMapping("/reject_examine/{GoodsID}")
    public String rejectGoodsExamine(@PathVariable("GoodsID") Integer GoodsID){
        Integer i = goodsService.rejectExamine(GoodsID);
        return "redirect:/Tourist_Backstage/item_examine";
    }

    @RequestMapping("/item_examine")
    public String getPageItemExamine(@RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize,
                                     @RequestParam(value = "PageIndex",defaultValue = "1")Integer PageIndex,
                                     @RequestParam(value = "GoodsID",defaultValue = "") Integer GoodsID,
                                     @RequestParam(value = "GoodsName",defaultValue = "") String GoodsName,
                                     @RequestParam(value = "FranName",defaultValue = "") String FranName,
                                     @RequestParam(value = "Price",defaultValue = "") Integer Price,
                                     Model model){
        PageInfo<Goods> goodsList = null;
        List<String> franList = null;
        if(GoodsID == null && Price == null && GoodsName.isEmpty() && FranName.isEmpty()){
            goodsList = goodsService.getAllExamineGoods(PageSize,PageIndex);
            franList = goodsService.getAllExamineFranName();
        }else if(GoodsID == null && Price == null){
            goodsList = goodsService.getAllExamineGoodsWithOutGoodsIDAndPrice(PageSize,PageIndex,GoodsName,FranName);
            franList = goodsService.getAllExamineFranNameWithOutGoodsIDAndPrice(GoodsName,FranName);
        }else if(GoodsID != null && Price == null){
            goodsList = goodsService.getAllExamineGoodsByGoodsID(PageSize,PageIndex,GoodsName,FranName,GoodsID);
            franList = goodsService.getAllExamineFranNameByGoodsID(GoodsName,FranName,GoodsID);
        }else if(GoodsID == null && Price != null){
            goodsList = goodsService.getAllExamineGoodsByPrice(PageSize,PageIndex,GoodsName,FranName,Price);
            franList = goodsService.getAllExamineFranNameByPrice(GoodsName,FranName,Price);
        }else{
            goodsList = goodsService.getAllExamineGoodsByPriceAndGoodsID(PageSize,PageIndex,GoodsID,GoodsName,FranName,Price);
            franList = goodsService.getAllExamineFranNameByPriceAndGoodsID(GoodsID,GoodsName,FranName,Price);
        }

        model.addAttribute("Goods",goodsList);
        model.addAttribute("Frans",franList);

        model.addAttribute("GoodsID",GoodsID);
        model.addAttribute("GoodsName",GoodsName);
        model.addAttribute("FranName",FranName);
        model.addAttribute("Price",Price);
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_item_examine";
    }

    @GetMapping("/item_update/{GoodsID}")
    public String getPageItemUpdate(@PathVariable("GoodsID") Integer GoodsID,Model model){
        Goods goods = goodsService.getGoodsByID(GoodsID);
        ScenicSpot scenicSpot = goodsService.getScenicByID(goods.getSSID());
        String FranName = goodsService.getFranName(GoodsID);

        model.addAttribute("Goods",goods);
        model.addAttribute("Scenic",scenicSpot);
        model.addAttribute("FranName",FranName);
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_item_update";
    }

    @PostMapping("/item_update")
    public String goodsUpdate(Goods goods,ScenicSpot scenicSpot,@RequestParam("filePic1") MultipartFile file1,
                              @RequestParam("filePic2") MultipartFile file2,@RequestParam("filePic3") MultipartFile file3){
        String fileName1 = file1.getOriginalFilename();
        String filePath1 = FileUtil.getUploadFilePath();
        fileName1 = System.currentTimeMillis() + fileName1;

        try{
            FileUtil.uploadFile(file1.getBytes(),filePath1,fileName1);
        }catch (Exception e){
            e.printStackTrace();
        }
        String fileName2 = file2.getOriginalFilename();
        String filePath2 = FileUtil.getUploadFilePath();
        fileName2 = System.currentTimeMillis() + fileName2;

        try{
            FileUtil.uploadFile(file2.getBytes(),filePath2,fileName2);
        }catch (Exception e){
            e.printStackTrace();
        }

        String fileName3 = file3.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName3 = System.currentTimeMillis() + fileName3;

        try{
            FileUtil.uploadFile(file3.getBytes(),filePath,fileName3);
        }catch (Exception e){
            e.printStackTrace();
        }

        scenicSpot.setSSImage_1(fileName1);
        scenicSpot.setSSImage_2(fileName2);
        scenicSpot.setSSImage_3(fileName3);

        Integer i = goodsService.updateGood(goods);
        Integer j = goodsService.updateScenic(scenicSpot);
        return "redirect:/Tourist_Backstage/item_list";
    }

    @GetMapping("/seller_add")
    public String getPageSellerAdd(Model model){
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_seller_add";
    }

    @PostMapping("/seller_add")
    public String addSeller(Franchise franchise,@RequestParam("filePic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis() + fileName;

        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        franchise.setFranImage(fileName);
        franchise.setBalance(0);

        Integer i = franchiseService.addFran(franchise);

        return "redirect:/Tourist_Backstage/seller_list";
    }

    @GetMapping("/seller_update/{FranID}")
    public String updateSeller(@PathVariable("FranID") Integer FranID,Model model){
        Franchise franchise = franchiseService.findFranByID(FranID);

        model.addAttribute("Fran",franchise);
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_update_seller";
    }

    @PostMapping("/seller_update")
    public String updateSeller(Franchise franchise,@RequestParam("filePic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis() + fileName;

        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        franchise.setFranImage(fileName);

        Integer i = franchiseService.updateFranByID(franchise);
        return "redirect:/Tourist_Backstage/seller_list";
    }

    @GetMapping("/delete_seller/{FranID}")
    public String deleteSeller(@PathVariable("FranID") Integer FranID){
        Integer i = franchiseService.deleteFranByID(FranID);
        return "redirect:/Tourist_Backstage/seller_list";
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
        States.add("退款中");
        States.add("已退款");
        States.add("已结束");
        States.add("退款拒绝");

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

        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);

        return "backstage_order_list";
    }

    @GetMapping("/order_details/{OrderID}")
    public String updateOrder(@PathVariable("OrderID") Integer OrderID,Model model){
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
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_order_details";
    }

    @PostMapping("/update_order")
    public String updateOrder(Order order){
        Integer i = orderService.changePrice(order);
        return "redirect:/Tourist_Backstage/order_list";
    }

    @GetMapping("/delete_order/{OrderID}")
    public String deleteOrder(@PathVariable("OrderID") Integer OrderID){
        Integer i = orderService.deleteOrderByID(OrderID);
        return "redirect:/Tourist_Backstage/order_list";
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
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_seller_list";
    }

    @GetMapping("/statistics")
    public String getPageStatistics(Model model){
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
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



        model.addAttribute("Manager",manager);
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
        return "backstage_statistics";
    }

    @GetMapping("/update_user/{UserID}")
    public String getPageUpdateUser(@PathVariable("UserID") Integer UserID,Model model){
        User user = touristService.findUserByID(UserID);
        model.addAttribute("User",user);
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_update_user";
    }

    @PostMapping("/update_user")
    public String updateUser(User user,@RequestParam("filePic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = user.getUserName() + fileName;

        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setUserImage(fileName);

        Integer i = touristService.updateUserByID(user);

        return "redirect:/Tourist_Backstage/user_list";
    }

    @GetMapping("/user_add")
    public String getPageUserAdd(Model model){
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_user_add";
    }

    @PostMapping("/user_add")
    public String addUser(User user, @RequestParam("filePic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis() + fileName;

        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setUserImage(fileName);
        user.setTag1(null);
        user.setTag2(null);
        user.setTag2(null);
        user.setBalance(0);

        Integer i = touristService.addUser(user);

        return "redirect:/Tourist_Backstage/user_list";
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
        Login login = loginService.getLoginUser();
        Manager manager = adminService.findManagerByID(login.getID());
        model.addAttribute("Manager",manager);
        return "backstage_user_list";
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

    @GetMapping("/delete_user/{UserID}")
    public String deleteUser(@PathVariable("UserID") Integer UserID){
        Integer i = touristService.deleteUserByID(UserID);
        return "redirect:/Tourist_Backstage/user_list";
    }

}
