package com.finalwork.service.userservice.service.lmpl;

import com.finalwork.service.common.bussiness.dto.user.UserRegisterDTO;
import com.finalwork.service.common.bussiness.entityDO.user.UserDO;
import com.finalwork.service.common.bussiness.entityVO.UserVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.userservice.convert.UserConvert;
import com.finalwork.service.userservice.dao.UserMapper;
import com.finalwork.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public UserVO findById(Long userId){
        UserDO userDO = userMapper.selectById(userId);
        return UserConvert.INSTANCE.convert(userDO);
    }

    @Transactional(rollbackFor = Exception.class)
    public CommonResult<UserVO> userRegister(UserRegisterDTO dto){
        if (isExist(dto.getUsername())){
            return CommonResult.failed(100,"username is already exist");
        }
        UserDO userDO = new UserDO();
        userDO.setName(dto.getUsername());
        userDO.setPassword(dto.getPassword());
        userDO.setMobile(dto.getMobile());
        userMapper.insert(userDO);
        UserDO user = userMapper.getOneByUserName(dto.getUsername());
        return success(UserConvert.INSTANCE.convert(user));

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
