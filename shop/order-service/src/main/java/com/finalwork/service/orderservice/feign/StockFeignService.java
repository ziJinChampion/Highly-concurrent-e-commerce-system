package com.finalwork.service.orderservice.feign;

import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.orderservice.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-service", path = "/stock")
public interface StockFeignService {

    @GetMapping
    CommonResult<Boolean> deductStock(@RequestParam("id") Long id, @RequestParam("num") Integer num);

}
