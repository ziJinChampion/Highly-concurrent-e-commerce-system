package com.finalwork.service.common.bussiness.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("search product dto")
public class ProductSearchDTO {

    @ApiModelProperty(value = "product id", required = false, example = "123")
    private Long id;

    @ApiModelProperty(value = "product name", required = false, example = "123")
    private String name;

    @ApiModelProperty(value = "product star", required = false, example = "123")
    private Integer star;

    @ApiModelProperty(value = "sort by ", required = false, example = "123")
    private Integer sort;

    private Integer pageSize;

    private Integer pageNum;
}
