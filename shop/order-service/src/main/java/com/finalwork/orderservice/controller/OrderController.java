package com.finalwork.orderservice.controller;

import com.finalwork.common.bussiness.dto.order.OrderCreateDTO;
import com.finalwork.common.utils.error.GlobalErrorCode;
import com.finalwork.common.utils.result.CommonResult;
import com.finalwork.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.finalwork.common.utils.result.CommonResult.success;
import static com.finalwork.common.utils.result.CommonResult.failed;

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
        return failed(GlobalErrorCode.STOCK_NOT_ENOUGH.getCode(),GlobalErrorCode.STOCK_NOT_ENOUGH.getMessage() );
    }
}
