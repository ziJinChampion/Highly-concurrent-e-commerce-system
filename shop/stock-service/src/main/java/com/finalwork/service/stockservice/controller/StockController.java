package com.finalwork.service.stockservice.controller;

import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.finalwork.service.common.utils.result.CommonResult.success;
import static com.finalwork.service.common.utils.result.CommonResult.failed;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/{id}/{num}")
    public CommonResult<Boolean> deductStock(@PathVariable("id")Long id,@PathVariable("num")Integer num){
        CommonResult result = stockService.deductStock(id,num);
        if (result.getCode() == 200){
            return success(true);
        }else {
            return failed(result.getCode(),result.getMessage(),false);
        }

    }
}
