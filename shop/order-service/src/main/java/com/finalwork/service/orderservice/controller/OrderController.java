package com.finalwork.service.orderservice.controller;

import com.finalwork.service.common.bussiness.dto.order.OrderCreateDTO;
import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import com.finalwork.service.common.utils.error.GlobalErrorCode;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.orderservice.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @ApiOperation(value = "创建订单")
    public CommonResult<String> createOrder(@RequestBody @Validated OrderCreateDTO orderCreateDTO){
        try {
            return success(orderService.createOrder(orderCreateDTO));
        }catch (Exception e){
            e.printStackTrace();
        }
        return success(GlobalErrorCode.STOCK_NOT_ENOUGH.getMessage());
    }

    @GetMapping
    @ApiOperation("获取用户历史订单")
    public CommonResult<List<OrderVO>> getUserOrderList(@RequestParam("userId") Integer userId){
        return success(orderService.getUserOrderList(userId));
    }
}
