package com.finalwork.service.creditservice.service;

import com.finalwork.service.common.bussiness.dto.credit.CreditAddDTO;
import com.finalwork.service.common.bussiness.dto.credit.CreditPayDTO;
import com.finalwork.service.common.bussiness.entityDO.credit.CreditDO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.creditservice.convert.CreditConvert;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface CreditService {

    CreditVO getNowCredit(Integer id);

    Boolean addCredit(CreditAddDTO dto);

    Boolean payCredit(CreditPayDTO dto);
}
