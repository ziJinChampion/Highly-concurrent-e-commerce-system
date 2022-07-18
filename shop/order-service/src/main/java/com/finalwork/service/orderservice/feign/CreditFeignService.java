package com.finalwork.service.orderservice.feign;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.utils.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "credit-service", path = "/credit")
public interface CreditFeignService {


    @PostMapping
    CommonResult<Boolean> addCredit(@RequestBody CreditAddDTO dto);


}
