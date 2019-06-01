package com.example.springboot.shiro;

import com.example.springboot.pojo.SysUser;
import com.example.springboot.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

     @Autowired
     SysUserService sysUserService;

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {



        return null;
    }

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    /*    String name ="a";
        String  password="pass";*/

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = null;
        try {
            sysUser = sysUserService.selectByUserName(token.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
        /*if (!name.equals(token.getUsername())){
            *//*>>>>>>>>>>>*//*
            return  null;
        }*/
        int hashIterations = 10000;//加密的次数
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, token.getPassword(),
                token.getUsername(), hashIterations);

        String  realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(token.getUsername());

        return new SimpleAuthenticationInfo(token.getUsername(),sysUser.getPassword() , credentialsSalt, realmName);
   }
}
