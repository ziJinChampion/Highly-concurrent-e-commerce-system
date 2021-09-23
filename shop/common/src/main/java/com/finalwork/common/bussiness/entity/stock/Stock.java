package com.finalwork.common.bussiness.entity.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("Stock")
public class Stock {
    @ApiModelProperty(name = "stockId")
    private Long id;
    @ApiModelProperty(name = "productId")
    private Long productId;
    @ApiModelProperty(name = "stockNum")
    private Integer num;
}
