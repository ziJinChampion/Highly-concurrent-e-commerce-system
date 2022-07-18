package com.finalwork.service.common.bussiness.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ProductStarDTO {

    private Integer userId;

    private Integer productId;

    private Date addTime;
}
