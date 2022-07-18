package com.finalwork.service.common.bussiness.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("order_detail")
public class OrderItem {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("order_id")
    private Long orderId;
    @TableField("product_id")
    private Long productId;
    @TableField("number")
    private Integer productNum;
    @TableField("total_cost")
    private Double totalCost;
    @TableField("seller_id")
    private Integer sellerId;
    @TableField("remark")
    private String remark;

    public OrderItem(Long orderId, Long productId, Integer productNum, Double totalCost, Integer sellerId, String remark) {
        this.orderId = orderId;
        this.productId = productId;
        this.productNum = productNum;
        this.totalCost = totalCost;
        this.sellerId = sellerId;
        this.remark = remark;
    }
}
