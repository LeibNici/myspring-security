package com.cm.mapper;

import com.cm.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    public SysUser selectSysUserByUserAccount(String userAccount);

}
