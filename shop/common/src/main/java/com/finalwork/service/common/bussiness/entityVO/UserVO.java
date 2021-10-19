package com.finalwork.service.common.bussiness.entityVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("userVO")
public class UserVO {
    @ApiModelProperty(value = "userId")
    private Long id;
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
