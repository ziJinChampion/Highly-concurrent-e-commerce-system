package com.finalwork.service.orderservice.feign;

import com.finalwork.service.common.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("stock-service")
public interface StockService {

    @GetMapping("/stock/{id}/{num}")
    CommonResult<Boolean> deductStock(@PathVariable("id") Long id,@PathVariable("num") Integer num);

}
