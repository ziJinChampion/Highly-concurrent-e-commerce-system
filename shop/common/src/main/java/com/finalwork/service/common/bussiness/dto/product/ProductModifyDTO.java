package com.finalwork.service.common.bussiness.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductModifyDTO {
    private Long id;

    private String name;

    private String photo;

    private Double price;

    private Integer itemId;

    private String remark;

    private String detail;

    private Integer sellerId;

    private String sellerName;
}
