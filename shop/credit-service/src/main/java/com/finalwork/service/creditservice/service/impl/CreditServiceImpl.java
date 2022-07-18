package com.finalwork.service.creditservice.service.impl;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.bussiness.dto.credit.CreditPayDTO;
import com.finalwork.service.common.bussiness.entityDO.credit.CreditDO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.creditservice.convert.CreditConvert;
import com.finalwork.service.creditservice.dao.CreditMapper;
import com.finalwork.service.creditservice.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreditServiceImpl  implements CreditService {

    @Autowired
    CreditMapper creditMapper;

    @Override
    public CreditVO getNowCredit(Integer id){
        CreditDO creditDO = creditMapper.getNowCredit(id);
        return CreditConvert.INSTANCE.convert(creditDO);
    }

    @Override
    public Boolean addCredit(CreditAddDTO dto) {
        CreditDO nowCredit = creditMapper.getNowCredit(dto.getUserId());
        dto.setPoint(dto.getPoint() * 0.5);
        if (nowCredit != null){
            creditMapper.addCredit(dto);
        }else {
            creditMapper.createCredit(dto);
        }
        return true;
    }

    @Override
    public Boolean payCredit(CreditPayDTO dto) {
        CreditDO nowCredit = creditMapper.getNowCredit(dto.getUserId());
        if (nowCredit.getPoint() < dto.getPoint()){
            return false;
        }
        creditMapper.payCredit(dto);
        return true;
    }
}
