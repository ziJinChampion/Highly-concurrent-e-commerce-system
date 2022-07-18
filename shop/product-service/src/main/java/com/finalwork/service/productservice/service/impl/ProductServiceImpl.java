package com.finalwork.service.productservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finalwork.service.common.bussiness.dto.product.ProductAddDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductModifyDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductStarDTO;
import com.finalwork.service.common.bussiness.dto.stock.StockAddDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import com.finalwork.service.common.bussiness.entityVO.item.ItemVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductDetailVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.bussiness.entityVO.user.UserInfoVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.common.utils.result.PageResult;
import com.finalwork.service.productservice.convert.ProductConvert;
import com.finalwork.service.productservice.dao.ProductMapper;
import com.finalwork.service.productservice.feign.StockFeignService;
import com.finalwork.service.productservice.feign.UserFeignService;
import com.finalwork.service.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserFeignService userFeignService;

    @Autowired
    StockFeignService stockFeignService;

    @Override
    public PageResult<ProductVO> getProductList(ProductSearchDTO dto) {
        dto.setPageNum((dto.getPageNum() - 1) * dto.getPageSize());
        PageResult<ProductVO> result = new PageResult<>();
        List<ProductDO> dos = productMapper.getList(dto);
        List<ProductVO> vos = ProductConvert.INSTANCE.convertList(dos);
        result.setList(vos);
        result.setTotal((long)productMapper.selectCount(new QueryWrapper<>()));
        return result;
    }

    @Override
    public List<ProductVO> getUserProductList(Integer id) {
        List<ProductDO> userProductList = productMapper.getUserProductList(id);
        return ProductConvert.INSTANCE.convertList(userProductList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addProduct(ProductAddDTO dto) {
        ProductDO productDO = ProductConvert.INSTANCE.convert(dto);
        CommonResult<UserInfoVO> loginUserInfo = userFeignService.getLoginUserInfo(dto.getSellerId());
        productDO.setSellerName(
                loginUserInfo.getData().getName()
        );
        if (productMapper.insert(productDO) !=0) {
            StockAddDTO stockAddDTO = new StockAddDTO();
            Integer newProductId = productMapper.getNewProductId(dto.getPhoto(), dto.getName(), dto.getSellerId());
            stockAddDTO.setProductId(newProductId);
            stockAddDTO.setUserId(dto.getSellerId());
            stockAddDTO.setNumber(dto.getStock());
            stockFeignService.addStock(stockAddDTO);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean modifyProduct(ProductModifyDTO dto) {
        ProductDO productDO = ProductConvert.INSTANCE.convert(dto);
        if (productMapper.updateById(productDO) !=0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean delProduct(Integer id) {
        productMapper.deleteById(id);
        return true;
    }

    @Override
    public Integer getPageNum() {
        return productMapper.count();
    }

    @Override
    public ProductDetailVO getProductDetailVO(Integer id) {
        return productMapper.getProductDetail(id);
    }

    @Override
    public List<ItemVO> getItem() {
        return productMapper.getItem();
    }

    @Override
    public Boolean starProduct(ProductStarDTO dto) {
        Integer star = productMapper.getStar(dto);
        if (star>0){
            return false;
        }
        productMapper.increaseStar(dto.getProductId());
        dto.setAddTime(new Date());
        productMapper.addStar(dto);
        return true;
    }

    @Override
    public List<ProductDetailVO> getStarProductList(Integer id) {
        return productMapper.getStarProductList(id);
    }
}
