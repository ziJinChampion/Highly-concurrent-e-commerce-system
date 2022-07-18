package com.finalwork.service.productservice.feign;

import com.finalwork.service.common.bussiness.dto.stock.StockAddDTO;
import com.finalwork.service.common.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", path = "/stock")
public interface StockFeignService {

    @PostMapping
    CommonResult<Integer> addStock(@RequestBody StockAddDTO stockAddDTO);
}
