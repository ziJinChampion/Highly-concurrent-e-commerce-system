package com.finalwork.service.common.bussiness.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @TableField("status")
    /**
     * 0 create
     * 1 waitPay
     * 2 finish
     * -1 cancel
     */
    private Integer status;
    @TableField("finish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    private Integer userId;

    public Order(String name, String totalPrice, Date addTime, Integer status, Date finishTime, Integer userId) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.addTime = addTime;
        this.status = status;
        this.finishTime = finishTime;
        this.userId = userId;
    }
}
