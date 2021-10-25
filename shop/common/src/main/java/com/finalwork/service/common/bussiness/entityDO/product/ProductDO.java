package com.finalwork.service.common.bussiness.entityDO.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("product")
public class ProductDO {
    /**
     productId
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * productName
     */
    @TableField(value = "name")
    private String name;
    /**
     * productPhoto
     */
    @TableField(value = "photo")
    private String photo;
    /**
     * productPrice
     */
    @TableField(value = "price")
    private double price;

    @TableField(value = "item_id")
    private Integer itemId;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "detail")
    private String detail;
    //shou cang
    @TableField(value = "star")
    private Integer star;

    @TableField(value = "seller_id")
    private Long sellerId;

    @TableField(value = "seller_name")
    private String sellerName;
}
