package com.cm.service.impl;

import com.cm.domain.SysUser;
import com.cm.mapper.SysUserMapper;
import com.cm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectSysUserByUserAccount(String userAccount) {
        return sysUserMapper.selectSysUserByUserAccount(userAccount);
    }
}
