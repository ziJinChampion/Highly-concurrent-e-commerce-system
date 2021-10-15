package com.finalwork.service.common.bussiness.entityVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("CreditVO")
public class CreditVO {
    @ApiModelProperty(value = "userId", required = true, example = "1233214")
    private Long userId;

    @ApiModelProperty(value = "credit-point", required = true, example = "100.2")
    private String point;
}
