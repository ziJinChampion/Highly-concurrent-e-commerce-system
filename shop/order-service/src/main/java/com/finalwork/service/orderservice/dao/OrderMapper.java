package com.finalwork.service.orderservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.entityDO.order.OrderDO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper  extends BaseMapper<OrderDO> {

    default OrderDO getByName(String name){
        return selectOne(new QueryWrapper<OrderDO>().eq("name",name));
    }

    void cancelOrder(Integer id);

    List<OrderVO> getOrderList(Integer userId);



}
