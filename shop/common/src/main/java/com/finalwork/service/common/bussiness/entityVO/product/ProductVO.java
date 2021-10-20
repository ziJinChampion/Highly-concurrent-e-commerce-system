package com.finalwork.service.common.bussiness.entityVO.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("productVO")
public class ProductVO {
    /**
     productId
     */
    @ApiModelProperty(value = "")
    private Long id;
    /**
     * productName
     */
    @ApiModelProperty(value = "name")
    private String name;
    /**
     * productPhoto
     */
    @ApiModelProperty(value = "photo")
    private String photo;
    /**
     * productPrice
     */
    @ApiModelProperty(value = "price")
    private double price;

    @ApiModelProperty(value = "itemId")
    private Integer itemId;

    @ApiModelProperty(value = "star")
    private Integer star;

    @ApiModelProperty(value = "sellerId")
    private String sellerId;
    @ApiModelProperty(value = "sellerName")
    private String sellerName;
}
