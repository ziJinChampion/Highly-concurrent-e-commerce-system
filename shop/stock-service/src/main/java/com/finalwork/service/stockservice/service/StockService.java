package com.finalwork.service.stockservice.service;

import com.finalwork.service.common.bussiness.dto.stock.StockAddDTO;
import com.finalwork.service.common.utils.result.CommonResult;


public interface StockService {

    CommonResult<String> deductStock(Long id, Integer num);

    CommonResult<Integer> addStock(StockAddDTO dto);


}
