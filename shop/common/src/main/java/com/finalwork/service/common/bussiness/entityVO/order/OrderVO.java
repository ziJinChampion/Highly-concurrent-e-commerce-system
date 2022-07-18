package com.finalwork.service.common.bussiness.entityVO.order;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
public class OrderVO {

    private String name;

    private Integer id;

    private String productName;

    private Integer number;

    private String photo;

    private Double totalCost;

    private String  userName;

    private String sellerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;
}
