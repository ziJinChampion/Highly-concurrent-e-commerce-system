package com.finalwork.service.productservice.controller;

import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.common.utils.result.PageResult;
import com.finalwork.service.productservice.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ApiOperation("get product list")
    public CommonResult<PageResult<ProductVO>> getList(@RequestBody @Validated ProductSearchDTO dto){
        return success(productService.getProductList(dto));
    }

//    public CommonResult<Boolean> addProduct(){
//
//    }
}
