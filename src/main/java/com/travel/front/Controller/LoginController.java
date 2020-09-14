package com.travel.front.Controller;


import com.travel.front.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String userLoginPressed(UserType userType){

        Integer i = loginService.login(userType);
        if(i == 1)
            return "index_T";
        else return "login";
    }
}
