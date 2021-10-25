package com.finalwork.service.creditservice.service;

import com.finalwork.service.common.bussiness.entityDO.credit.CreditDO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import com.finalwork.service.creditservice.convert.CreditConvert;

public interface CreditService {

    CreditVO getNowCredit(Integer id);
}
