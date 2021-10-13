package com.finalwork.service.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("credit-service")
public interface CreditService {
}
