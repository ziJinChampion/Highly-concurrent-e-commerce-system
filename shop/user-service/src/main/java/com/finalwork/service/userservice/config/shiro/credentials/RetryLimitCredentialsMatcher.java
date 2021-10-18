package com.finalwork.service.userservice.config.shiro.credentials;

import com.finalwork.service.common.bussiness.entity.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RetryLimitCredentialsMatcher extends CredentialsMatcher{

    @Autowired
    RedisTemplate redisTemplate;

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        Integer userId = (Integer) info.getPrincipals().getPrimaryPrincipal();
        User user = (User) redisTemplate.opsForValue().get("userId");
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
        return true;
    }

}
