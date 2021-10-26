package com.finalwork.service.stockservice.controller;

import com.finalwork.service.common.bussiness.dto.stock.StockAddDTO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import static com.finalwork.service.common.utils.result.CommonResult.success;
import static com.finalwork.service.common.utils.result.CommonResult.failed;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}/{num}")
    public CommonResult<Boolean> deductStock(@PathVariable("id")Long id,@PathVariable("num")Integer num){
        CommonResult result = stockService.deductStock(id,num);
        if (result.getCode() == 200){
            return success(true);
        }else {
            return failed(result.getCode(),result.getMessage(),false);
        }
    }

    @PutMapping
    public CommonResult<Integer> addStock(@RequestBody StockAddDTO stockAddDTO){
        //TODO: get userID
        stockAddDTO.setUserId(100L);
        return stockService.addStock(stockAddDTO);
    }

}
