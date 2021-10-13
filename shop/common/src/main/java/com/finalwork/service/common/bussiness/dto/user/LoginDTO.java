package com.finalwork.service.common.bussiness.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("user login dto")
@Accessors(chain = true)
public class LoginDTO {
    @NotBlank(message = "username not null")
    @ApiModelProperty(value = "username", required = true, example = "12783")
    private String username;
    @ApiModelProperty(value = "password", required = true, example = "123213")
    @NotBlank(message = "password not null")
    private String password;
}
