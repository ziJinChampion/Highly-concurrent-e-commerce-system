package com.finalwork.service.productservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<ProductDO> {

    List<ProductDO> getList(ProductSearchDTO dto);

    Integer count();

}
