package com.finalwork.common.bussiness.entityDO.stock;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@TableName("stock")
public class StockDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "productId")
    private Long productId;
    @TableField(value = "num")
    private Integer num;
}
