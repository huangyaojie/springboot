package com.example.springboot.service.serviceimpl;

import com.example.springboot.mapper.SysUserMapper;
import com.example.springboot.pojo.SysUser;
import com.example.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper mapper;

    @Override
    public SysUser selectByUserName(String userName) {
        return  mapper.selectByUserName(userName);
    }
}
