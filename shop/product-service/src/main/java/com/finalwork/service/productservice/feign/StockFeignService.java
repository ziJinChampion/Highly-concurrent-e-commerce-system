package com.finalwork.service.productservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "stock-service", url = "/stock")
public interface StockFeignService {

}
