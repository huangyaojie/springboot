package com.example.springboot.config;

import com.example.springboot.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    /*
    * 创建shiroFilterFactoryBean
    * */
    @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean( @Qualifier("securityManager")DefaultWebSecurityManager securityManager){
      ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
      shiroFilterFactoryBean.setSecurityManager(securityManager);
      /*shiro常用内置过滤器
      * anon:
      * authc:
      * user:针对remember
      * perms:必须有资源权限
      * role:角色权限
      *
      *
      * */
        LinkedHashMap<String, String> fileterChainDefinationMap= new LinkedHashMap<>();/*保证顺序*/
     /*   fileterChainDefinationMap.put("/add","authc");
        fileterChainDefinationMap.put("/update","authc");*/


       /* fileterChainDefinationMap.put("/","anon");
        fileterChainDefinationMap.put("/hello","anon");*/
        fileterChainDefinationMap.put("/login","anon");

        fileterChainDefinationMap.put("/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fileterChainDefinationMap);
      //设置login的url
        shiroFilterFactoryBean.setLoginUrl("/tologin");

      return shiroFilterFactoryBean;
  }

    /*
     * 创建DefaultWebSecurityManager
     * */

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager( @Qualifier("userRealm")UserRealm userRealm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(userRealm);
    return securityManager;
}
    /*
     * 创建Realm
     * */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
       return new UserRealm();
    }
}
