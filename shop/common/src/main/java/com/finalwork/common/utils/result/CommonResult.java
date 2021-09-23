package com.finalwork.common.utils.result;

import com.finalwork.common.utils.error.GlobalErrorCode;
import lombok.AllArgsConstructor;
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


}
