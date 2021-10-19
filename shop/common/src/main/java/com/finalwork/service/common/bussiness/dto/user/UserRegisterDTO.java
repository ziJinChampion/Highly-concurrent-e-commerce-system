package com.finalwork.service.common.bussiness.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@ApiModel("user-registerDTO")
public class UserRegisterDTO {
    @ApiModelProperty(value = "username", required = true, example = "southwind")
    @NotBlank(message = "username cant be null")
    private String username;
    @ApiModelProperty(value = "password", required = true, example = "123456")
    @NotBlank(message = "password cant be null")
    private String password;
    @ApiModelProperty(value = "mobile", required = true, example = "13333333")
    @NotBlank(message = "mobile cant be null")
    private String mobile;
}
