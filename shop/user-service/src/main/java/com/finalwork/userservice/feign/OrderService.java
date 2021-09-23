package com.finalwork.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "order-service")
public interface OrderService {

    @PostMapping("/order")
    String createOrder();
}
