package com.finalwork.service.productservice.service;

import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.PageResult;

public interface ProductService {


    PageResult<ProductVO> getProductList(ProductSearchDTO dto);


}

