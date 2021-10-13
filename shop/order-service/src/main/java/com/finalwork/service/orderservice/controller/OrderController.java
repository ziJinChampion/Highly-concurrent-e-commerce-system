package com.finalwork.service.orderservice.controller;

import com.finalwork.service.common.bussiness.dto.order.OrderCreateDTO;
import com.finalwork.service.common.utils.error.GlobalErrorCode;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.finalwork.service.common.utils.result.CommonResult.success;
import static com.finalwork.service.common.utils.result.CommonResult.failed;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public CommonResult<String> createOrder(@RequestBody @Validated OrderCreateDTO orderCreateDTO){
        try {
            return success(orderService.createOrder(orderCreateDTO));
        }catch (Exception e){
            e.printStackTrace();
        }
        return success(GlobalErrorCode.STOCK_NOT_ENOUGH.getMessage());
    }
}
