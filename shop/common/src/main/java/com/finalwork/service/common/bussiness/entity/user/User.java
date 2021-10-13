package com.finalwork.service.common.bussiness.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("user")
@ApiModel("user Model")
public class User {
    @ApiModelProperty(value = "userId")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "userName")
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "userPassword")
    @TableField("password")
    private String password;
    @ApiModelProperty(value = "userPhoto")
    @TableField("photo")
    private String photo;
    @ApiModelProperty(value = "userMobile")
    @TableField("mobile")
    private String mobile;
    @ApiModelProperty(value = "userRemark")
    @TableField("remark")
    private String remark;
}
