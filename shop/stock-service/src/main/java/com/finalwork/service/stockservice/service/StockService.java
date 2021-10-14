package com.finalwork.service.stockservice.service;

import com.finalwork.service.common.bussiness.entityDO.stock.StockDO;
import static com.finalwork.service.common.utils.result.CommonResult.success;
import static com.finalwork.service.common.utils.result.CommonResult.failed;

import com.finalwork.service.common.utils.error.GlobalErrorCode;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.stockservice.dao.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    StockMapper stockMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public CommonResult<String> deductStock(Long id, Integer num){
        StockDO stockDO = stockMapper.getStockByProductId(id);
        if (stockDO == null) {
            return failed(GlobalErrorCode.PRODUCT_IS_NOT_EXIST.getCode(), GlobalErrorCode.PRODUCT_IS_NOT_EXIST.getMessage());
        }
        //update stock num
        //TODO: recheck stock when do Refactor
        if (stockDO.getNum() >= num){
            stockDO.setNum(stockDO.getNum() - num);
            stockMapper.updateById(stockDO);
            return success("success");
        }else {
            return failed(GlobalErrorCode.STOCK_NOT_ENOUGH.getCode(), GlobalErrorCode.STOCK_NOT_ENOUGH.getMessage());
        }
    }


}
