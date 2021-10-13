package com.finalwork.service.common.utils.error;



public enum GlobalErrorCode {
    INNER_ERROR(500,"inner error"),
    STOCK_NOT_ENOUGH(511,"stock is not enough"),
    PRODUCT_IS_NOT_EXIST(512,"product is not exist");

    private Integer code ;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    GlobalErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
