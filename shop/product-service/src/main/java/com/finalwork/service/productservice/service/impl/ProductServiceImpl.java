package com.finalwork.service.productservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.PageResult;
import com.finalwork.service.productservice.convert.ProductConvert;
import com.finalwork.service.productservice.dao.ProductMapper;
import com.finalwork.service.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public PageResult<ProductVO> getProductList(ProductSearchDTO dto) {
        PageResult<ProductVO> result = new PageResult<>();
        List<ProductDO> dos = productMapper.selectList(new QueryWrapper<>());
        List<ProductVO> vos = ProductConvert.INSTANCE.convertList(dos);
        result.setList(vos);
        result.setTotal((long)productMapper.selectCount(new QueryWrapper<>()));
        return result;
    }
}
