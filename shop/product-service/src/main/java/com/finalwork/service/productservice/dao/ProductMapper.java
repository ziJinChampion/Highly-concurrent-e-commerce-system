package com.finalwork.service.productservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductStarDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import com.finalwork.service.common.bussiness.entityVO.item.ItemVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductDetailVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<ProductDO> {

    List<ProductDO> getList(ProductSearchDTO dto);

    List<ProductDetailVO> getStarProductList(Integer id);

    List<ProductDO> getUserProductList(Integer id);

    Integer count();

    ProductDetailVO getProductDetail(Integer id);

    List<ItemVO> getItem();

    Integer getNewProductId(@Param("photo") String photo,@Param("name")String name,@Param("sellerId") Integer sellerId);

    void increaseStar(Integer id);

    void addStar(ProductStarDTO dto);

    Integer getStar(ProductStarDTO dto);


}
