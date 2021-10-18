package com.finalwork.service.common.bussiness.entity.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;

@ApiModel("loginUser")
@Data
public class SysUser {
    private Long id;

    private String name;

    private Integer status;

    private Timestamp lastLoginTime;
}
