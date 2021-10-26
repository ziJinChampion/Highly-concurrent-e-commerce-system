package com.finalwork.service.common.bussiness.entityDO.stock;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

@Data
@Accessors
@TableName("stock")
public class StockDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "product_id")
    private Long productId;
    @TableField(value = "number")
    private Integer num;
    @TableField(value = "seller_id")
    private Long sellerId;
}
