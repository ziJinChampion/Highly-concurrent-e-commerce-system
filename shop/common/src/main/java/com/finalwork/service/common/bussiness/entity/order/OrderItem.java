package com.finalwork.service.common.bussiness.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("order")
public class OrderItem {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("orderId")
    private Long orderId;
    @TableField("productId")
    private Long productId;
    @TableField("productNum")
    private Integer productNum;

    public OrderItem(Long orderId, Long productId, Integer productNum){
        this.orderId = orderId;
        this.productId = productId;
        this.productNum = productNum;
    }
}
