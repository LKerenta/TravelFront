package com.travel.front.Controller;

import com.travel.front.Entity.Franchise;
import com.travel.front.Entity.Manager;
import com.travel.front.Entity.User;
import com.travel.front.Entity.UserType;
import com.travel.front.Mapper.LoginMapper;
import com.travel.front.Service.LoginService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Tourist")
public class LoginController {
    @Autowired
    private LoginService loginService;

    //http://localhost:8080/travel/login
    @GetMapping("/login")
    public String getPageLogin(){
        return "login";
    }

    @PostMapping("/index")
    public String userLoginPressed(UserType userType, Model model){
        Integer i = loginService.Login(userType);

        if(i==0){
            Manager manager = loginService.RM(userType);
            model.addAttribute("Info",manager);
            return "backstage_index";
        }else if(i == 1){
            Franchise franchise = loginService.RF(userType);
            model.addAttribute("Info",franchise);
            return "index_F";
        }else if(i == 2){
            User user = loginService.RT(userType);
            model.addAttribute("Info",user);
            return "index_T";
        }else
            return "login";

    }

}
