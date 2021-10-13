package com.finalwork.service.common.bussiness.entityDO.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@TableName("order")
@Data
@Accessors(chain = true)
public class OrderDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;
    @TableField("totalPrice")
    private String totalPrice;
    @TableField("addTime")
    private Date addTime;
    @TableField("status")
    private Integer status;
}
