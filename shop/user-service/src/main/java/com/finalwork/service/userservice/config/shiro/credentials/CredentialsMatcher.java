package com.finalwork.service.userservice.config.shiro.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialsMatcher extends SimpleCredentialsMatcher {


    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        String inPassword = new String ( uToken.getPassword());
        String dbPassword = (String) info.getCredentials();

        //TODO: encryptPassword

        return inPassword.equals(dbPassword);

    }
}
