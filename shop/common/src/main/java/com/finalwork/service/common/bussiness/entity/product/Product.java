package com.finalwork.service.common.bussiness.entity.product;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Product {
    /**
     productId
     */
    private Long id;
    /**
     * productName
     */
    private String name;
    /**
     * productPhoto
     */
    private String photo;
    /**
     * productPrice
     */
    private double price;

    private Integer itemId;

    private String remark;

    private String detail;
    //shou cang
    private Integer star;

    private Long sellerId;

    private String sellerName;


}
