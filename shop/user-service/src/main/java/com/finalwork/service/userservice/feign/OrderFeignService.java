package com.finalwork.service.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "order-service", path = "/order")
public interface OrderFeignService {

    @PostMapping("/order")
    String createOrder();
}