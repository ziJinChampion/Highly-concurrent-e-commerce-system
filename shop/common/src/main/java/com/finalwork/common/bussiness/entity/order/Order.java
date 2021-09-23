package com.finalwork.common.bussiness.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName("order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;
    @TableField("totalPrice")
    private String totalPrice;
    @TableField("addTime")
    private Date addTime;
    @TableField("status")
    /**
     * 0 create
     * 1 waitPay
     * 2 finish
     * -1 cancel
     */
    private Integer status;

    public Order (String name, String totalPrice, Date addTime, Integer status){
        this.name = name;
        this.totalPrice = totalPrice;
        this.addTime = addTime;
        this.status = status;
    }
}
