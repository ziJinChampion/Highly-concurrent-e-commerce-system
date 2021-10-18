package com.finalwork.service.userservice.config.shiro.token;

import lombok.Data;

import java.util.Date;

@Data
public class SysUserToken {
    private Long userId;
    private String token;
    private Date LastUpdateTime;
    private Date ExpireTime;
}
