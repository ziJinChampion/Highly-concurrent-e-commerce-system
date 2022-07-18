package com.finalwork.service.productservice.convert;

import com.finalwork.service.common.bussiness.dto.product.ProductAddDTO;
import com.finalwork.service.common.bussiness.dto.product.ProductModifyDTO;
import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.PageResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T12:02:29+0800",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class ProductConvertImpl implements ProductConvert {

    @Override
    public ProductVO convert(ProductDO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductVO productVO = new ProductVO();

        productVO.setId( bean.getId() );
        productVO.setName( bean.getName() );
        productVO.setPhoto( bean.getPhoto() );
        productVO.setPrice( bean.getPrice() );
        productVO.setItemId( bean.getItemId() );
        productVO.setStar( bean.getStar() );
        if ( bean.getSellerId() != null ) {
            productVO.setSellerId( String.valueOf( bean.getSellerId() ) );
        }
        productVO.setSellerName( bean.getSellerName() );
        productVO.setDetail( bean.getDetail() );
        productVO.setRemark( bean.getRemark() );

        return productVO;
    }

    @Override
    public List<ProductVO> convertList(List<ProductDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductVO> list1 = new ArrayList<ProductVO>( list.size() );
        for ( ProductDO productDO : list ) {
            list1.add( convert( productDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<ProductVO> convertPage(PageResult<ProductDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<ProductVO> pageResult = new PageResult<ProductVO>();

        pageResult.setPages( page.getPages() );
        pageResult.setCurrent( page.getCurrent() );
        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public ProductDO convert(ProductAddDTO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductDO productDO = new ProductDO();

        productDO.setName( bean.getName() );
        productDO.setPhoto( bean.getPhoto() );
        if ( bean.getPrice() != null ) {
            productDO.setPrice( bean.getPrice() );
        }
        productDO.setItemId( bean.getItemId() );
        productDO.setRemark( bean.getRemark() );
        productDO.setDetail( bean.getDetail() );
        if ( bean.getSellerId() != null ) {
            productDO.setSellerId( bean.getSellerId().longValue() );
        }
        productDO.setSellerName( bean.getSellerName() );

        return productDO;
    }

    @Override
    public ProductDO convert(ProductModifyDTO bean) {
        if ( bean == null ) {
            return null;
        }

        ProductDO productDO = new ProductDO();

        productDO.setId( bean.getId() );
        productDO.setName( bean.getName() );
        productDO.setPhoto( bean.getPhoto() );
        if ( bean.getPrice() != null ) {
            productDO.setPrice( bean.getPrice() );
        }
        productDO.setItemId( bean.getItemId() );
        productDO.setRemark( bean.getRemark() );
        productDO.setDetail( bean.getDetail() );
        if ( bean.getSellerId() != null ) {
            productDO.setSellerId( bean.getSellerId().longValue() );
        }
        productDO.setSellerName( bean.getSellerName() );

        return productDO;
    }
}
