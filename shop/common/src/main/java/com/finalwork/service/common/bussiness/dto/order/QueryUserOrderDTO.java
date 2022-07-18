package com.finalwork.service.common.bussiness.dto.order;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class QueryUserOrderDTO {

    private Integer userId;

}
