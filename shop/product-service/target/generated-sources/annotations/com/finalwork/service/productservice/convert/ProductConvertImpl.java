package com.finalwork.service.productservice.convert;

import com.finalwork.service.common.bussiness.entityDO.product.ProductDO;
import com.finalwork.service.common.bussiness.entityVO.product.ProductVO;
import com.finalwork.service.common.utils.result.PageResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-25T09:05:13+0800",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
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
}
