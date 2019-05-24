package com.example.springboot.service;

import com.example.springboot.pojo.SysUser;



public interface SysUserService  {

   SysUser selectByUserName(String userName);

}
