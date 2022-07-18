package com.finalwork.service.orderservice.service;


import com.finalwork.service.common.bussiness.dto.order.OrderCreateDTO;
import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;

import java.util.List;

public interface OrderService {

    List<OrderVO> getUserOrderList(Integer userId);

    String createOrder(OrderCreateDTO orderCreateDTO);
}