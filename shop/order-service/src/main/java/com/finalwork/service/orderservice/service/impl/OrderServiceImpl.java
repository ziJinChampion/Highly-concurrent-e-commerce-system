package com.finalwork.service.orderservice.service.impl;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.bussiness.dto.order.OrderCreateDTO;
import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.entity.order.Order;
import com.finalwork.service.common.bussiness.entity.order.OrderItem;
import com.finalwork.service.common.bussiness.entityDO.order.OrderDO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import com.finalwork.service.common.exception.StockException;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.orderservice.convert.OrderConvert;
import com.finalwork.service.orderservice.dao.OrderItemMapper;
import com.finalwork.service.orderservice.dao.OrderMapper;
import com.finalwork.service.orderservice.feign.CreditFeignService;
import com.finalwork.service.orderservice.feign.StockFeignService;
import com.finalwork.service.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    StockFeignService stockFeignService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    CreditFeignService creditFeignService;

    @Override
    public List<OrderVO> getUserOrderList(Integer userId) {
        return orderMapper.getOrderList(userId);
    }

    @Transactional(rollbackFor = StockException.class)
    @Override
    public String createOrder(OrderCreateDTO orderCreateDTO) {
        log.info("create order");
        try {
            if (orderCreate(orderCreateDTO)) {
                creditFeignService.addCredit(new CreditAddDTO(orderCreateDTO.getUserId(), orderCreateDTO.getTotalPrice()));
                return "create success!";
            }
        } catch (StockException e) {
            e.printStackTrace();
            return "create failed";
        }

        //TODO: reCheck
        return "success";
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean orderCreate(OrderCreateDTO orderCreateDTO) throws StockException {
        //获取订单编号
        Long orderId = InitOrderId(orderCreateDTO);
        //商品编号
        Long productId = orderCreateDTO.getProductId();
        //商品数量
        Integer productNum = orderCreateDTO.getProductNum();

        CommonResult<Boolean> result = stockFeignService.deductStock(productId, productNum);
        if (orderCreateDTO.getRemark() == null || "".equals(orderCreateDTO.getRemark())){
            orderCreateDTO.setRemark("ordinary order default");
        }
        if (result.getData()) {
            OrderItem temp = new OrderItem(orderId, productId, productNum, orderCreateDTO.getTotalPrice(),
                    orderCreateDTO.getSellerId(), orderCreateDTO.getRemark());
            orderItemMapper.insert(temp);
        } else {
            throw new StockException("PRODUCT " + productId + "IS SOLD OUT!");
        }

        return true;
    }

    /**
     * @param orderCreateDTO
     * @Description init OrderId
     * @Author southWind
     */
    @Transactional(rollbackFor = Exception.class)
    public Long InitOrderId(OrderCreateDTO orderCreateDTO) {
        Date date = new Date();
        Order order = new Order(
                orderCreateDTO.getName()+orderCreateDTO.getAddTime().toString(),
                orderCreateDTO.getTotalPrice().toString(),
                orderCreateDTO.getAddTime(),
                0,
                date,
                orderCreateDTO.getUserId()
        );
        OrderDO orderDO = OrderConvert.INSTANCE.convert(order);
        orderMapper.insert(orderDO);
        Long ans = orderMapper.getByName(orderDO.getName()).getId();
        return ans;
    }

    public void cancelOrder(Integer orderId) {

    }


}
