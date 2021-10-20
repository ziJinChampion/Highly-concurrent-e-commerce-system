package com.finalwork.service.common.bussiness.entity.Item;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
/**
 * fen lei
 */
@TableName("item")
public class Item {

    private Integer id;
    private String name;
    private Integer parent_id;
    private Integer sort;
    private String icon;
    private Integer show_status;
    private List<Item> children;
}
