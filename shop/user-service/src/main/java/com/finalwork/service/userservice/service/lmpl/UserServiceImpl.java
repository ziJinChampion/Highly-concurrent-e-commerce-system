package com.finalwork.service.userservice.service.lmpl;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.bussiness.dto.order.QueryUserOrderDTO;
import com.finalwork.service.common.bussiness.dto.user.UserRegisterDTO;
import com.finalwork.service.common.bussiness.entityDO.user.UserDO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.bussiness.entityVO.order.OrderVO;
import com.finalwork.service.common.bussiness.entityVO.user.UserInfoVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.userservice.convert.UserConvert;
import com.finalwork.service.userservice.dao.UserMapper;
import com.finalwork.service.userservice.feign.CreditFeigenService;
import com.finalwork.service.userservice.feign.OrderFeignService;
import com.finalwork.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    CreditFeigenService creditFeigenService;

    @Autowired
    OrderFeignService orderFeignService;

    @Override
    public UserVO findById(Long userId){
        UserDO userDO = userMapper.selectById(userId);
        return UserConvert.INSTANCE.convert(userDO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult<UserVO> userRegister(UserRegisterDTO dto){
        if (isExist(dto.getUsername())){
            return CommonResult.failed(100,"username is already exist");
        }
        UserDO userDO = new UserDO();
        userDO.setName(dto.getUsername());
        userDO.setPassword(dto.getPassword());
        userDO.setMobile(dto.getMobile());
        userDO.setRemark("普通用户");
        userDO.setRole(2);
        userMapper.insert(userDO);
        UserDO user = userMapper.getOneByUserName(dto.getUsername());
        creditFeigenService.addCredit(new CreditAddDTO(user.getId().intValue(),0.0));
        return success(UserConvert.INSTANCE.convert(user));
    }

    @Override
    public List<OrderVO> getUserOrderList(QueryUserOrderDTO dto) {
        CommonResult<List<OrderVO>> userOrderList = orderFeignService.getUserOrderList(dto.getUserId());
        return userOrderList.getData();
    }

    @Override
    public UserInfoVO getLoginUserInfo(Integer id) {
        CommonResult<CreditVO> nowCredit = creditFeigenService.getNowCredit(id);
        CreditVO data = nowCredit.getData();
        UserInfoVO loginUserInfo = userMapper.getLoginUserInfo(id);
        loginUserInfo.setPoint(data.getPoint());
        return loginUserInfo;
    }

    private boolean isExist(String userName){
        UserDO oneByUserName = userMapper.getOneByUserName(userName);
        if (oneByUserName!=null){
            return true;
        }else {
            return false;
        }
    }

}
