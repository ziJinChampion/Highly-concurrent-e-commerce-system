package com.finalwork.orderservice.convert;

import com.finalwork.common.bussiness.entity.order.Order;
import com.finalwork.common.bussiness.entityDO.order.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderConvert {
    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    OrderDO convert(Order bean);
}
