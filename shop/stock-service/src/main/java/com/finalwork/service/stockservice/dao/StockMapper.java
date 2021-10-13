package com.finalwork.service.stockservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.entityDO.stock.StockDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper extends BaseMapper<StockDO> {

    default StockDO getStockByProductId(Long id){
        return selectOne(new QueryWrapper<StockDO>().eq("productId",id));
    }

}
