package com.finalwork.service.orderservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.entity.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
