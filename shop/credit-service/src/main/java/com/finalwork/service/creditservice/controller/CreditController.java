package com.finalwork.service.creditservice.controller;

import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.creditservice.service.CreditService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@RequestMapping("/credit")
@ApiModel("CreditManage")
public class CreditController {

    @Autowired
    CreditService creditService;

    @GetMapping("/{id}")
    @ApiOperation("getNowCredit")
    public CommonResult<CreditVO> getNowCredit(@PathVariable Integer id){
        return success(creditService.getNowCredit(id));
    }

}
