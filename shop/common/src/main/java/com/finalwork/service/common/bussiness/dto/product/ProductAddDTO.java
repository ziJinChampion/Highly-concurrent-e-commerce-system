package com.finalwork.service.common.bussiness.dto.product;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("添加商品DTO")
public class ProductAddDTO {
    private String name;

    private String photo;

    private Double price;

    private Integer itemId;

    private String remark;

    private String detail;

    private Integer sellerId;

    private String sellerName;

    private Integer stock;
}
