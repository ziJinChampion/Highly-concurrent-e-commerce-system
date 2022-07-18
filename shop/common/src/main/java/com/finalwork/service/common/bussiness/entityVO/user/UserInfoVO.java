package com.finalwork.service.common.bussiness.entityVO.user;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVO {

    private Integer id;

    private String name;

    private String photo;

    private String mobile;

    private String remark;

    private String role;

    private Double point;
}
