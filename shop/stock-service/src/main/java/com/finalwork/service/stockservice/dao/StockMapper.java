package com.finalwork.service.stockservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.dto.stock.StockAddDTO;
import com.finalwork.service.common.bussiness.entityDO.stock.StockDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper extends BaseMapper<StockDO> {


    default StockDO getStockByProductId(@Param("id") Integer id){
        return selectOne(new QueryWrapper<StockDO>().eq("product_id",id));
    }

    Integer addStock(StockAddDTO dto);

    Integer createStock(StockAddDTO dto);



}
