package com.finalwork.common.bussiness.entity.product;

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
    private Integer photo;
    /**
     * productPrice
     */
    private String price;


}
