package com.travel.front.Controller;


import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.travel.front.Entity.UserType;

import java.util.List;

@Controller
@RequestMapping("Tourist")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }
    @PostMapping("/index")
    public String userLoginPressed(UserType userType, Model model){

        Integer i = loginService.login(userType);


        if(i == 0)
        {
            Manager manager = loginService.RM(userType);
            model.addAttribute("Info",manager);
            return "index";
        }
        else if(i == 1)
        {
            Franchise franchise = loginService.RF(userType);
            model.addAttribute("Info",franchise);
            return "index_F";
        }
        else if(i == 2)
        {
            User user = loginService.RT(userType);
            model.addAttribute("Info",user);
            return "index_T";
        }
        else return "login";
    }
}
