package com.finalwork.service.userservice.feign;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.common.utils.result.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@FeignClient("credit-service")
public interface CreditFeigenService {

    @GetMapping("/credit/{id}")
    CommonResult<CreditVO> getNowCredit(@PathVariable("id") Integer id);

    @PostMapping("/credit")
    CommonResult<Boolean> addCredit(@RequestBody CreditAddDTO dto);

}
