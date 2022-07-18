package com.finalwork.service.creditservice.controller;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.bussiness.dto.credit.CreditPayDTO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.creditservice.service.CreditService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@RequestMapping("/credit")
@ApiModel("CreditManage")
public class CreditController {

    @Autowired
    CreditService creditService;

    @GetMapping("/{id}")
    @ApiOperation("获取当前积分")
    public CommonResult<CreditVO> getNowCredit(@PathVariable("id") Integer id){
        return success(creditService.getNowCredit(id));
    }

    @PostMapping
    @ApiOperation("增加积分")
    public CommonResult<Boolean> addCredit(@RequestBody CreditAddDTO dto){
        return success(creditService.addCredit(dto));
    }

    @PutMapping
    @ApiOperation("花费积分")
    public CommonResult<Boolean> payCredit(@RequestBody CreditPayDTO dto){
        return success(creditService.payCredit(dto));
    }

}
