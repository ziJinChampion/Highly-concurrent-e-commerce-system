package com.finalwork.service.userservice.service;

import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.dto.user.UserRegisterDTO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.bussiness.entityVO.user.UserInfoVO;
import com.finalwork.service.common.utils.result.CommonResult;
import io.swagger.models.auth.In;

import java.util.List;

public interface UserService {
    UserVO findById(Long userId);

    CommonResult<UserVO> userRegister(UserRegisterDTO dto);

    List<OrderVO> getUserOrderList(QueryUserOrderDTO dto);


    UserInfoVO getLoginUserInfo(Integer id);


}
