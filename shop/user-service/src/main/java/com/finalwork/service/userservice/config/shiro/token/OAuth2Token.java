package com.finalwork.service.userservice.config.shiro.token;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义 token 对象
 * @author Louis
 * @date Sep 1, 2018
 */
public class OAuth2Token implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
