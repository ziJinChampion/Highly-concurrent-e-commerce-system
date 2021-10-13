package com.finalwork.service.orderservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.entityDO.order.OrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper  extends BaseMapper<OrderDO> {

    default OrderDO getByName(String name){
        return selectOne(new QueryWrapper<OrderDO>().eq("name",name));
    }

    void cancelOrder(Integer id);

}
