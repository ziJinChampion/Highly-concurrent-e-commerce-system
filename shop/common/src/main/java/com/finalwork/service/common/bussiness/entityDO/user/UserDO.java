package com.finalwork.service.common.bussiness.entityDO.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("user")
@Accessors(chain = true)
public class UserDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "password")
    private String password;
    @TableField(value = "photo")
    private String photo;
    @TableField(value = "mobile")
    private String mobile;
    @TableField(value = "remark")
    private String remark;
    @TableField(value = "status")
    private Integer status;

}
