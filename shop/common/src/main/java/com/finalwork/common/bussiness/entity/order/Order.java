package com.finalwork.common.bussiness.entity.order;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Integer id;

    private String name;

    private String price;

    private Date addTime;
}
