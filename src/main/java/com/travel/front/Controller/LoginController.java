package com.travel.front.Controller;


import com.travel.front.Entity.*;
import com.travel.front.Service.FranchiseService;
import com.travel.front.Service.GoodsService;
import com.travel.front.Service.LoginService;
import com.travel.front.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("Tourist")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private TouristService touristService;

    @GetMapping("/login")
    public String userLogin(){
        loginService.logOut();
        return "login";
    }

    @GetMapping("/forget_password")
    public String forget(){
        return "forget_password";
    }

    @PostMapping("/forget_password")
    public String forgetPassword(User user){
        User user1 = touristService.findUserByID(user.getUserID());
        if(user.getPhone().equals(user1.getPhone())){
            user1.setPassword(user.getPassword());
        }
        Integer i = touristService.updateUserByID(user1);
        return "redirect:/Tourist/login";
    }

    @PostMapping("/index")
    public String userLoginPressed(UserType userType, Model model){

        Integer i = loginService.login(userType);



        if(i == 0)
        {
            Manager manager = loginService.RM(userType);
            Login login = loginService.getLoginUser();
            model.addAttribute("Manager",manager);
            return "redirect:/Tourist_Backstage/index";
        }
        else if(i == 1)
        {
            Franchise franchise = loginService.RF(userType);
            Login login = loginService.getLoginUser();
            List<Goods> items = goodsService.getGoodsByFranID(franchise.getFranID());
            List<Order> orders = franchiseService.getOrdersByFran(franchise.getFranID());
            model.addAttribute("Info",login);
            model.addAttribute("items",items);
            model.addAttribute("orders",orders);
            return "redirect:/Franchise/index";
        }
        else if(i == 2)
        {
            User user = loginService.RT(userType);
            Login login = loginService.getLoginUser();
            model.addAttribute("Info",login);
            return "redirect:/Tourist_T/index";
        }
        else return "login";
    }
    @GetMapping("/index/register")
    public String RegPage(){
        return "register";
    }

    @PostMapping("/login/register")
    public String Registry(Register register,Model model){
        Integer i = register.getType();
        if(i == 1){
            Franchise franchise = new Franchise();
            franchise.setFranName(register.getUser_name());
            franchise.setPassword(register.getPassword());
            franchise.setPhone(register.getPhone());
            loginService.Registry(franchise);
            UserType userType = new UserType();
            userType.setID(franchise.getFranID());
            userType.setPassword(register.getPassword());
            userType.setType(i);
            Integer j = loginService.userTypeInsert(userType);
            return "login";
        }
        if(i == 2){
            User user = new User();
            user.setUserName(register.getUser_name());
            user.setPassword(register.getPassword());
            user.setPhone(register.getPhone());
            loginService.Registry(user);
            UserType userType = new UserType();
            userType.setID(user.getUserID());
            userType.setPassword(register.getPassword());
            userType.setType(i);
            Integer j = loginService.userTypeInsert(userType);
            return "login";
        }
        return null;
    }
}
