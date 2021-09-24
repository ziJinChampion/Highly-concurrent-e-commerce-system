package com.finalwork.stockservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.common.bussiness.entityDO.stock.StockDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper extends BaseMapper<StockDO> {

    default StockDO getStockByProductId(Long id){
        return selectOne(new QueryWrapper<StockDO>().eq("productId",id));
    }

}
