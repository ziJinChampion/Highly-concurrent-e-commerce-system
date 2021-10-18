package com.finalwork.service.userservice.controller;

import com.finalwork.service.common.bussiness.dto.user.LoginDTO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.userservice.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@Api(tags = "userCenter")
@RequestMapping("/user")
public class UserController {

}
