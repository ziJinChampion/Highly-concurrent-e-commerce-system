package com.finalwork.common.bussiness.entityVO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("userVO")
public class UserVO {
    @ApiModelProperty(value = "userId")
    private Integer id;
    @ApiModelProperty(value = "userName")
    private String name;
    @ApiModelProperty(value = "userPassword")
    private String password;
    @ApiModelProperty(value = "userPhoto")
    private String photo;
    @ApiModelProperty(value = "userMobile")
    private String mobile;
    @ApiModelProperty(value = "userRemark")
    private String remark;
}
