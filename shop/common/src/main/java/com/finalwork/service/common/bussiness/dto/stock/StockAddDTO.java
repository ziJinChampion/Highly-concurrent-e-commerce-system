package com.finalwork.service.common.bussiness.dto.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors
@ApiModel("stock add dto")
public class StockAddDTO {

    @ApiModelProperty(value = "sellerId", required = false, example = "100")
    private Long userId;

    @ApiModelProperty(value = "productId", required = true, example = "200")
    @NotNull(message = "productId can not be null")
    private Long productId;

    @ApiModelProperty(value = "number", required = true, example = "300")
    @NotNull(message = "product add number can not be null")
    private Integer number;
}
