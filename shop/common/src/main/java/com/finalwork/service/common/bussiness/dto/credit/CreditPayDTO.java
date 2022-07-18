package com.finalwork.service.common.bussiness.dto.credit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors
@AllArgsConstructor
public class CreditPayDTO {
    private Integer userId;

    private Double point;
}
