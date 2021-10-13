package com.finalwork.service.orderservice.convert;

import com.finalwork.service.common.bussiness.entity.order.Order;
import com.finalwork.service.common.bussiness.entityDO.order.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderConvert {
    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    OrderDO convert(Order bean);
}
