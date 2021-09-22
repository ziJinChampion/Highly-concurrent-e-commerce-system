package com.finalwork.userservice.controller;

import com.finalwork.common.bussiness.dto.user.LoginDTO;
import com.finalwork.common.utils.result.CommonResult;
import com.finalwork.userservice.service.UserService;
import com.netflix.client.http.HttpRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.finalwork.common.utils.result.CommonResult.success;

@RestController
@Api(tags = "userCenter")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public CommonResult<String> login(@RequestBody @Validated LoginDTO loginDTO){
        if (userService.checkLogin(loginDTO)){
            return success("success");
        }
        return success("username or password error!");
    }




}
