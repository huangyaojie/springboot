package com.example.springboot.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {


    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name ="a";
        String  password="pass";
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (!name.equals(token.getUsername())){
            /*>>>>>>>>>>>*/
            return  null;
        }


        return new SimpleAuthenticationInfo("",password,"");
    }
}
