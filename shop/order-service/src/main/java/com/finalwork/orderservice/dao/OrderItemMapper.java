package com.finalwork.orderservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.common.bussiness.entity.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
