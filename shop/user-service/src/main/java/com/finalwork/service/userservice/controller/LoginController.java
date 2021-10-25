package com.finalwork.service.userservice.controller;

import com.finalwork.service.common.bussiness.dto.user.LoginDTO;
import com.finalwork.service.common.bussiness.dto.user.UserRegisterDTO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.userservice.service.LoginService;
import com.finalwork.service.userservice.service.UserService;
import com.finalwork.service.userservice.service.lmpl.LoginServiceImpl;
import com.finalwork.service.userservice.service.lmpl.UserServiceImpl;
import com.finalwork.service.userservice.vo.LoginRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@Api(tags = "loginCenter")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @PostMapping
    @ApiOperation(value = "login")
    public CommonResult<LoginRespVO> login(@RequestBody @Validated LoginDTO loginDTO){
        return success(loginService.checkLogin(loginDTO));
    }

    @ApiOperation(value = "register")
    @PostMapping("/register")
    public CommonResult<UserVO> register(@RequestBody @Validated UserRegisterDTO dto){
        return userService.userRegister(dto);
    }
}
