package com.finalwork.service.userservice.service;

import com.finalwork.service.userservice.config.shiro.token.SysUserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SysUserTokenService {

    @Autowired
    RedisTemplate redisTemplate;

    public SysUserToken findByToken(String token){
        SysUserToken sysUserToken = (SysUserToken) redisTemplate.opsForValue().get(token);
        return sysUserToken;
    }
}
