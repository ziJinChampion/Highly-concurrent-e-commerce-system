package com.finalwork.service.userservice.service;

import com.finalwork.service.common.bussiness.dto.user.LoginDTO;
import com.finalwork.service.common.bussiness.entityDO.user.UserDO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.userservice.convert.UserConvert;
import com.finalwork.service.userservice.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

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
}
