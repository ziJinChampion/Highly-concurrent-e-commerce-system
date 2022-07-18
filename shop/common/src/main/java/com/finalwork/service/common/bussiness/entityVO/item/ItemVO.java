package com.finalwork.service.common.bussiness.entityVO.item;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemVO {
    private Integer id;

    private String name;
}
