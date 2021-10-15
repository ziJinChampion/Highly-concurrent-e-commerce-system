package com.finalwork.service.creditservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.entityDO.credit.CreditDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CreditMapper extends BaseMapper<CreditDO> {

    default CreditDO getNowCredit(Integer id){
        return selectOne(new QueryWrapper<CreditDO>()
                .eq("userId",id));
    }

}
