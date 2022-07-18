package com.finalwork.service.productservice.service;

import com.finalwork.service.common.bussiness.dto.product.ProductAddDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductModifyDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductStarDTO;
import com.finalwork.service.common.bussiness.entityVO.item.ItemVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductDetailVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.PageResult;

import java.util.List;

public interface ProductService {


    PageResult<ProductVO> getProductList(ProductSearchDTO dto);

    List<ProductVO> getUserProductList(Integer id);

    Boolean addProduct(ProductAddDTO dto);

    Boolean modifyProduct(ProductModifyDTO dto);

    Boolean delProduct(Integer id);

    Integer getPageNum();

    ProductDetailVO getProductDetailVO(Integer id);

    List<ItemVO> getItem();

    Boolean starProduct(ProductStarDTO dto);

    List<ProductDetailVO> getStarProductList(Integer id);


}

