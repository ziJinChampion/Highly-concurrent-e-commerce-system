package com.finalwork.service.common.bussiness.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel("/OrderCreateDTO")
public class OrderCreateDTO {

    @ApiModelProperty(name = "orderName", required = true, example = "productName+num")
    @NotBlank
    private String name;

    @ApiModelProperty(name = "productId", required = true, example = "[112,223]")
    @NotNull
    private Long productId;

    @ApiModelProperty(name = "productNum", required = true, example = "[1,2]")
    @NotNull
    private Integer productNum;

    @ApiModelProperty(name = "totalPrice", required = true, example = "123.1273")
    @NotNull
    private Double totalPrice;

    @ApiModelProperty(name = "addTime", required = false, example = "2021-09-23 18:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    @ApiModelProperty(name = "userId", required = true, example = "1001")
    @NotNull
    private Integer userId;

    @ApiModelProperty(name = "卖家编号", required = true ,example = "12231")
    private Integer sellerId;

    @ApiModelProperty(name = "备注", required = false, example = "this is a .....")
    private String remark;
}
