package com.finalwork.service.userservice.service;

import com.finalwork.service.common.bussiness.dto.user.LoginDTO;
import com.finalwork.service.common.bussiness.entityDO.user.UserDO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.utils.common.TokenGenerator;
import com.finalwork.service.userservice.config.shiro.token.SysUserToken;
import com.finalwork.service.userservice.convert.UserConvert;
import com.finalwork.service.userservice.dao.UserMapper;
import com.finalwork.service.userservice.vo.LoginRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    private final static Integer EXPIRE = 1800;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    public LoginRespVO checkLogin(LoginDTO loginDTO){
        UserDO user = userMapper.getOneByUserName(loginDTO.getUsername());
        LoginRespVO loginRespVO = new LoginRespVO();
        if (user == null){
            loginRespVO.setMessage("username or password wrong!");
            return loginRespVO;
        }else {
            if (!user.getPassword().equals(loginDTO.getPassword())){
                loginRespVO.setMessage("username or password wrong!");
                return loginRespVO;            }
        }
        SysUserToken token = createToken(user.getId());
        loginRespVO.setToken(token);
        return loginRespVO;
    }

    public UserVO getCurrentUser(String username){
        UserDO userDO = userMapper.getOneByUserName(username);
        return UserConvert.INSTANCE.convert(userDO);
    }

    //create Token
    public SysUserToken createToken(Long userId){
        String token = TokenGenerator.generateToken();
        Date now = new Date();
        //TODO: should be more exactly
        Date expireTime = new Date(now.getTime() + EXPIRE * 10);
        String redisToken = (String) redisTemplate.opsForValue().get(userId);
        SysUserToken sysUserToken = new SysUserToken();
        if (redisToken == null || "".equals(redisToken)){
            sysUserToken = new SysUserToken();
            sysUserToken.setUserId(userId);
            sysUserToken.setToken(token);
            sysUserToken.setLastUpdateTime(now);
            sysUserToken.setExpireTime(expireTime);
            redisTemplate.opsForValue().set(userId, token, EXPIRE*10, TimeUnit.SECONDS);
        }else {
            sysUserToken.setToken(token);
            sysUserToken.setLastUpdateTime(now);
            sysUserToken.setExpireTime(expireTime);
            redisTemplate.opsForValue().set(userId, token, EXPIRE*10, TimeUnit.SECONDS);
        }
        return sysUserToken;
    }
}
