package com.finalwork.common.bussiness.dto.order;

import lombok.Data;

import java.util.Date;

@Data
public class OrderCreateDTO {

    private String name;

    private String price;

    private Date addTime;
}
