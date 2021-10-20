package com.finalwork.service.common.utils.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

@ApiModel(" fen ye jie guo")
@Data
@Accessors(chain = true)
public final class PageResult<T> implements Serializable {
    @ApiModelProperty(value = "data list", required = true)
    private List<T> list;
    @ApiModelProperty(value = "all data list number",required = true)
    private Long total;
    @ApiModelProperty(value = "total page number",required = true)
    private Integer pages;
    @ApiModelProperty(value = "current page number",required = true)
    private Integer current;

    public PageResult<T> setPages(Integer pages){
        this.pages = pages;
        return this;
    }

    public PageResult<T> setCurrent(Integer current){
        this.current = current;
        return this;
    }

    public PageResult<T> setList(List<T> list){
        this.list = list;
        return this;
    }

    public PageResult<T> setTotal(Long total){
        this.total = total;
        return this;
    }


}
