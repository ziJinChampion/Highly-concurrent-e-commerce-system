package com.finalwork.orderservice.feign;

import com.finalwork.common.bussiness.dto.stock.StockReduceDTO;
import com.finalwork.common.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("stock-service")
public interface StockService {

    @GetMapping("/stock/{id}/{num}")
    CommonResult<Boolean> deductStock(@PathVariable("id") Long id,@PathVariable("num") Integer num);

}
