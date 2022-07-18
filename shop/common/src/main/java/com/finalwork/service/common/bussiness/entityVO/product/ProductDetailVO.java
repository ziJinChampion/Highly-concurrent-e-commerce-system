package com.finalwork.service.common.bussiness.entityVO.product;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductDetailVO {

    private Integer id;

    private String name;

    private String photo;

    private Double price;

    private String itemName;

    private String sellerName;

    private Integer sellerId;

    private Integer star;

    private String detail;

    private Integer stock;


}
