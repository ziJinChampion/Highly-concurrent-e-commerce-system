package com.finalwork.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.finalwork.common.bussiness.dto.user.LoginDTO;
import com.finalwork.common.bussiness.entity.user.User;
import com.finalwork.common.bussiness.entityDO.UserDO;
import com.finalwork.userservice.dao.UserMapper;
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
}
