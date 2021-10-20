package com.finalwork.service.productservice.controller;

import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.common.utils.result.PageResult;
import com.finalwork.service.productservice.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @ApiOperation("get product list")
    public CommonResult<PageResult<ProductVO>> getList(){
        return null;
    }

}
