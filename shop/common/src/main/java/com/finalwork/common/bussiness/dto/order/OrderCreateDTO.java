package com.finalwork.common.bussiness.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel("/OrderCreateDTO")
public class OrderCreateDTO {

    @ApiModelProperty(name = "orderName", required = true, example = "productName+num")
    @NotBlank
    private String name;

    @ApiModelProperty(name = "productId", required = true, example = "[112,223]")
    @NotBlank
    private List<Long> productId;

    @ApiModelProperty(name = "productNum", required = true, example = "[1,2]")
    @NotBlank
    private List<Integer> productNum;

    @ApiModelProperty(name = "totalPrice", required = true, example = "123.1273")
    @NotBlank
    private String totalPrice;

    @ApiModelProperty(name = "addTime", required = false, example = "2021-09-23 18:00:00")
    private Date addTime;
}
