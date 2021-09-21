package com.finalwork.common.utils.error;



public enum GlobalErrorCode {
    INNER_ERROR(500,"inner error");



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
