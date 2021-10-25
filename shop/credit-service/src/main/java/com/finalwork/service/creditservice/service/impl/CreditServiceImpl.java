package com.finalwork.service.creditservice.service.impl;

import com.finalwork.service.common.bussiness.entityDO.credit.CreditDO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.creditservice.convert.CreditConvert;
import com.finalwork.service.creditservice.dao.CreditMapper;
import com.finalwork.service.creditservice.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditServiceImpl  implements CreditService {

    @Autowired
    CreditMapper creditMapper;

    public CreditVO getNowCredit(Integer id){
        CreditDO creditDO = creditMapper.getNowCredit(id);
        return CreditConvert.INSTANCE.convert(creditDO);
    }
}