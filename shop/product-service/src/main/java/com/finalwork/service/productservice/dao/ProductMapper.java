package com.finalwork.service.productservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;

import java.util.List;

public interface ProductMapper extends BaseMapper<ProductDO> {

    List<ProductDO> getList(ProductSearchDTO dto);

    Integer count();

}
