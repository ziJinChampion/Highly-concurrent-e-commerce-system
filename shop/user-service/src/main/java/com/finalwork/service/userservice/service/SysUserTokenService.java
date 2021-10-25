package com.finalwork.service.userservice.service;

import com.finalwork.service.userservice.config.shiro.token.SysUserToken;

public interface SysUserTokenService {

    SysUserToken findByToken(String token);
}
