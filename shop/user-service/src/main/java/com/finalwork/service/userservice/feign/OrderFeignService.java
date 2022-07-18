package com.finalwork.service.userservice.feign;

import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import com.finalwork.service.common.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("order-service")
public interface OrderFeignService {

    @PostMapping
    String createOrder();

    @GetMapping("/order")
    CommonResult<List<OrderVO>> getUserOrderList(@RequestParam("userId") Integer userId);
}
