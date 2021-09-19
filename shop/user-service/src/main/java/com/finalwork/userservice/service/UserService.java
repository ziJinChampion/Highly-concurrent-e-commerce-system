package com.finalwork.userservice.service;

import com.finalwork.common.bussiness.dto.user.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean checkLogin(LoginDTO loginDTO){
        if ("zhangsan".equals(loginDTO.getUsername()) && "123".equals(loginDTO.getPassword())){
            return true;
        }
        return false;
    }
}
