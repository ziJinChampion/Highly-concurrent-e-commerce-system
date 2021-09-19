package com.finalwork.orderservice.controller;

import com.finalwork.common.bussiness.dto.order.OrderCreateDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @PostMapping("/")
    public String createOrder(OrderCreateDTO orderCreateDTO){
        return "success";
    }
}
