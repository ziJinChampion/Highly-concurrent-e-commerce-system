package com.finalwork.service.common.bussiness.dto.credit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class CreditAddDTO {

    private Integer userId;

    private Double point;


}
