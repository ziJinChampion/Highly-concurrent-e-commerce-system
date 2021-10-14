package com.finalwork.service.orderservice.feign;

import com.finalwork.service.orderservice.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "credit-service", path = "/credit")
public interface CreditFeignService {

}
