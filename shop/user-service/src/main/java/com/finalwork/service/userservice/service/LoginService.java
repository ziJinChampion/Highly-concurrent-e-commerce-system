package com.finalwork.service.userservice.service;

import com.finalwork.service.common.bussiness.dto.user.LoginDTO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.userservice.vo.LoginRespVO;

public interface LoginService {

    LoginRespVO checkLogin(LoginDTO loginDTO);

    UserVO getCurrentUser(String username);
}
