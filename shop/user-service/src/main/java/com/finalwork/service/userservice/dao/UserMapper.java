package com.finalwork.service.userservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.entityDO.user.UserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    default UserDO getOneByUserName(String name){
        return selectOne(new QueryWrapper<UserDO>()
                .eq("name",name));
    }

}
