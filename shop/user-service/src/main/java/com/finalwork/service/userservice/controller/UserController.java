package com.finalwork.service.userservice.controller;

import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.entity.user.User;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.bussiness.entityVO.user.UserInfoVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.finalwork.service.common.utils.result.CommonResult.success;

import java.util.List;

@RestController
@Api(tags = "userCenter")
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/order")
    @ApiOperation("查询用户历史订单")
    public CommonResult<List<OrderVO>> getUserOrderList(QueryUserOrderDTO dto){
        return success(userService.getUserOrderList(dto));
    }

    @GetMapping("/{id}")
    @ApiOperation("获取登录的用户信息")
    public CommonResult<UserInfoVO> getLoginUserInfo(@PathVariable("id") Integer userId){
        return success(userService.getLoginUserInfo(userId));
    }

}
