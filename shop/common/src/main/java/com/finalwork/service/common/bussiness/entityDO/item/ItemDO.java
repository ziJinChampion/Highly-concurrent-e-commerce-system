package com.finalwork.service.common.bussiness.entityDO.item;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.finalwork.service.common.bussiness.entity.Item.Item;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@TableName("item")
public class ItemDO {
    @TableId(value = "item_id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "item_name")
    private String name;
    @TableField(value = "parent_id")
    private Integer parent_id;
    @TableField(value = "sort")
    private Integer sort;
    @TableField(value = "icon")
    private String icon;
    @TableField(value = "show_status")
    private Integer show_status;
    @TableField(exist = false)
    private List<Item> children;
}
