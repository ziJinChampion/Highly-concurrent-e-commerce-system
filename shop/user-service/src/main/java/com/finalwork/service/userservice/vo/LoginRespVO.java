package com.finalwork.service.userservice.vo;

import com.finalwork.service.userservice.config.shiro.token.SysUserToken;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@ApiModel("login resp")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoginRespVO {
    @ApiModelProperty(value = "token")
    private SysUserToken token;
    @ApiModelProperty(value = "message")
    private String message;
}
