package com.finalwork.userservice.convert;

import com.finalwork.common.bussiness.entityDO.user.UserDO;
import com.finalwork.common.bussiness.entityVO.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserVO convert(UserDO bean);
}
