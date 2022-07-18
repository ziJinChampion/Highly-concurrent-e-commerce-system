package com.finalwork.service.productservice.feign;

import com.finalwork.service.common.bussiness.entityVO.user.UserInfoVO;
import com.finalwork.service.common.utils.result.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", path = "/user")
public interface UserFeignService {

    @GetMapping("/{id}")
    CommonResult<UserInfoVO> getLoginUserInfo(@PathVariable("id") Integer userId);
}
