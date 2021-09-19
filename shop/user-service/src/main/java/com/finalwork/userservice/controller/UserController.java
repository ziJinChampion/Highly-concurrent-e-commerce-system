package com.finalwork.userservice.controller;

import com.finalwork.common.bussiness.dto.user.LoginDTO;
import com.finalwork.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginDTO loginDTO){
        if (userService.checkLogin(loginDTO)){
            return "success";
        }
        return "failed";
    }
}
