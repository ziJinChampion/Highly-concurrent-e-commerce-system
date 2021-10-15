package com.finalwork.service.creditservice.convert;

import com.finalwork.service.common.bussiness.entityDO.credit.CreditDO;
import com.finalwork.service.common.bussiness.entityVO.CreditVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditConvert {
    CreditConvert INSTANCE = Mappers.getMapper(CreditConvert.class);

    CreditVO convert(CreditDO bean);
}
