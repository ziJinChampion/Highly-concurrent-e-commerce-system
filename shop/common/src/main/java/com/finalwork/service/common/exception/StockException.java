package com.finalwork.service.common.exception;

import lombok.Data;

@Data
public class StockException extends Exception{

    private Integer code;
    private String message;

    public StockException(String s){
        super(s);
    }
}
