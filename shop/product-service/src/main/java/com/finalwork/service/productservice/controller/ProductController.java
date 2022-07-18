package com.finalwork.service.productservice.controller;

import com.finalwork.service.common.bussiness.dto.product.ProductAddDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductModifyDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductSearchDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductStarDTO;
import com.finalwork.service.common.bussiness.entityVO.item.ItemVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductDetailVO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.CommonResult;
import com.finalwork.service.common.utils.result.PageResult;
import com.finalwork.service.productservice.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.finalwork.service.common.utils.result.CommonResult.success;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ApiOperation("获取商品列表")
    public CommonResult<PageResult<ProductVO>> getList(@RequestBody @Validated ProductSearchDTO dto){
        return success(productService.getProductList(dto));
    }

    @GetMapping("/user")
    @ApiOperation("获取用户的商品列表")
    public CommonResult<List<ProductVO>>  getUserList(@RequestParam("id") Integer id){
        return success(productService.getUserProductList(id));
    }

    @GetMapping("/{id}")
    @ApiOperation("获取具体商品信息")
    public CommonResult<ProductDetailVO> getProductDetail(@PathVariable("id")Integer id){
        return success(productService.getProductDetailVO(id));
    }

    @GetMapping("/item")
    public CommonResult<List<ItemVO>> getItem(){
        return success(productService.getItem());
    }


    @PostMapping("/new")
    @ApiOperation("添加商品")
    public CommonResult<Boolean> addProduct(@RequestBody @Validated ProductAddDTO dto){
        return success(productService.addProduct(dto));
    }

    @PutMapping
    @ApiOperation("修改商品信息")
    public CommonResult<Boolean> modifyProduct(@RequestBody @Validated ProductModifyDTO dto){
        return success(productService.modifyProduct(dto));
    }

    @DeleteMapping
    @ApiOperation("删除商品")
    public CommonResult<Boolean> delProduct(Integer id){
        return success(productService.delProduct(id));
    }

    @GetMapping("/pages")
    public CommonResult<Integer> getPageNum(){
        return success(productService.getPageNum());
    }

    @PostMapping("/star")
    public CommonResult<Boolean> starProduct(@RequestBody ProductStarDTO dto){
        return success(productService.starProduct(dto));
    }

    @GetMapping("/star/{id}")
    public CommonResult<List<ProductDetailVO>> getStarProductList(@PathVariable("id")Integer id){
        return success(productService.getStarProductList(id));
    }
}
