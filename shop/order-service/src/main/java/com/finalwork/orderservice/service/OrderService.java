package com.finalwork.orderservice.service;

import com.finalwork.common.bussiness.dto.order.OrderCreateDTO;
import com.finalwork.common.bussiness.dto.stock.StockReduceDTO;
import com.finalwork.common.bussiness.entity.order.Order;
import com.finalwork.common.bussiness.entity.order.OrderItem;
import com.finalwork.common.bussiness.entityDO.order.OrderDO;
import com.finalwork.common.exception.StockException;
import com.finalwork.common.utils.result.CommonResult;
import com.finalwork.orderservice.convert.OrderConvert;
import com.finalwork.orderservice.dao.OrderItemMapper;
import com.finalwork.orderservice.dao.OrderMapper;
import com.finalwork.orderservice.feign.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class OrderService {

    @Autowired
    StockService stockService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Transactional(rollbackFor = StockException.class)
    public String createOrder(OrderCreateDTO orderCreateDTO) {
        try {
            if (orderCreate(orderCreateDTO)){
                //TODO: jia ji fen
                return "create success!";
            }
        }catch (StockException e){
            e.printStackTrace();
            return "create failed";
        }

        //TODO: reCheck
        return "success";
    }
    @Transactional(rollbackFor = Exception.class)
    public Boolean orderCreate(OrderCreateDTO orderCreateDTO) throws StockException{
        int totalItem = orderCreateDTO.getProductId().size();
        Long orderId  = InitOrderId(orderCreateDTO);
        List<Long> productId = orderCreateDTO.getProductId();
        List<Integer> productNum = orderCreateDTO.getProductNum();
        for (int i = 0; i < totalItem; i++){
            Long pId = productId.get(i);
            Integer pNum = productNum.get(i);
            CommonResult<Boolean> result = stockService.deductStock(productId.get(i),productNum.get(i));
            if (result.getData()){
                OrderItem temp = new OrderItem(orderId,productId.get(i),productNum.get(i));
                orderItemMapper.insert(temp);
            }else {
                throw new StockException("PRODUCT "+productId.get(i)+"IS SOLD OUT!");
            }
        }
        return true;
    }

    /**
     * @Description init OrderId
     * @Author southWind
     * @param orderCreateDTO
     */
    public Long InitOrderId(OrderCreateDTO orderCreateDTO){
        Date date = new Date();
        Order order = new Order(
                orderCreateDTO.getName(),
                orderCreateDTO.getTotalPrice(),
                date,
                0
        );
        OrderDO orderDO= OrderConvert.INSTANCE.convert(order);
        orderMapper.insert(orderDO);
        Long ans = orderMapper.getByName(orderDO.getName()).getId();
        return ans;
    }

    public void cancelOrder(Integer orderId){

    }


}