package com.finalwork.service.common.bussiness.dto.stock;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("StockReduceDTO")
public class StockReduceDTO {

    private Long productId;

    private Integer num;
}
