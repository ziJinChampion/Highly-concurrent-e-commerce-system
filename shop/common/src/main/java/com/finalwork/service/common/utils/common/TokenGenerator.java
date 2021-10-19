package com.finalwork.service.common.utils.common;


import java.util.UUID;

public class TokenGenerator {

    public static String generateToken(){
        return UUID.randomUUID().toString();
    }
}
