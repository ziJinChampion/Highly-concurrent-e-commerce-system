package com.finalwork.service.common.utils.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, Object o) {
        this.code = code;
        this.message = message;
        this.data = (T) o;
    }

    public  CommonResult (Object o,String message){
        this.data = (T) data;
        this.message = message;
    }
    //TODO: checkerror
    public static <T> CommonResult<T> success (T data){
        return new CommonResult<>(200,"success",data);
    }

    public static <T> CommonResult<T> failed (Integer code, String message, T data){
        return new CommonResult<>(code,message,data);
    }
    public static <T> CommonResult<T> failed (Integer code, String message){
        return new CommonResult<>(code,message);
    }

    public static <T> CommonResult<T> error(T data, String message){
        return new CommonResult<>(data,message);
    }

}
