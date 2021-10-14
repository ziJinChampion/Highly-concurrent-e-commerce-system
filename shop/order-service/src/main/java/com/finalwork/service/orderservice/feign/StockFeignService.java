package com.finalwork.service.orderservice.feign;

import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.orderservice.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", path = "/stock")
public interface StockFeignService {

    @GetMapping("/{id}/{num}")
    CommonResult<Boolean> deductStock(@PathVariable("id") Long id,@PathVariable("num") Integer num);

}
