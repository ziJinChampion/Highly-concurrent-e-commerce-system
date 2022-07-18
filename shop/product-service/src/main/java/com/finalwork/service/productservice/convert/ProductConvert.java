package com.finalwork.service.productservice.convert;

import com.finalwork.service.common.bussiness.dto.product.ProductAddDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductModifyDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductConvert {
    ProductConvert INSTANCE = Mappers.getMapper(ProductConvert.class);

    ProductVO convert(ProductDO bean);

    List<ProductVO> convertList(List<ProductDO> list);

    PageResult<ProductVO> convertPage(PageResult<ProductDO> page);

    ProductDO convert(ProductAddDTO bean);

    ProductDO convert(ProductModifyDTO bean);
}
