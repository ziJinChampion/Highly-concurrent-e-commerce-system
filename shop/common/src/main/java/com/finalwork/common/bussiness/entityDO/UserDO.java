package com.finalwork.common.bussiness.entityDO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("user")
public class UserDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("password")
    private String password;
    @TableField("photo")
    private String photo;
    @TableField("mobile")
    private String mobile;
    @TableField("remark")
    private String remark;

}
