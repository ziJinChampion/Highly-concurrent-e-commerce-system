package com.finalwork.service.userservice.service;

import com.finalwork.service.common.bussiness.dto.user.LoginDTO;
import com.finalwork.service.common.bussiness.entityDO.user.UserDO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.utils.common.TokenGenerator;
import com.finalwork.service.userservice.config.shiro.token.SysUserToken;
import com.finalwork.service.userservice.convert.UserConvert;
import com.finalwork.service.userservice.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

    private final static Integer EXPIRE = 10;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    public boolean checkLogin(LoginDTO loginDTO){
        UserDO user = userMapper.getOneByUserName(loginDTO.getUsername());
        if (user == null){
            return false;
        }else {
            if (!user.getPassword().equals(loginDTO.getPassword())){
                return false;
            }
        }
        return true;
    }

    public UserVO getCurrentUser(String username){
        UserDO userDO = userMapper.getOneByUserName(username);
        return UserConvert.INSTANCE.convert(userDO);
    }

    //create Token
    public SysUserToken createToken(Long userId){
        String token = TokenGenerator.generateToken();
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        SysUserToken sysUserToken = (SysUserToken) redisTemplate.opsForValue().get(userId);
        if (sysUserToken == null){
            sysUserToken = new SysUserToken();
            sysUserToken.setUserId(userId);
            sysUserToken.setToken(token);
            sysUserToken.setLastUpdateTime(now);
            sysUserToken.setExpireTime(expireTime);
            redisTemplate.opsForValue().set(token,sysUserToken);
        }else {
            sysUserToken.setToken(token);
            sysUserToken.setLastUpdateTime(now);
            sysUserToken.setExpireTime(expireTime);
            redisTemplate.opsForValue().set(token,sysUserToken);
        }
        return sysUserToken;
    }
}
