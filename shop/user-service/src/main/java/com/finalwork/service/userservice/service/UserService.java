package com.finalwork.service.userservice.service;

import com.finalwork.service.common.bussiness.dto.user.UserRegisterDTO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.utils.result.CommonResult;

public interface UserService {
    UserVO findById(Long userId);

    CommonResult<UserVO> userRegister(UserRegisterDTO dto);
}
