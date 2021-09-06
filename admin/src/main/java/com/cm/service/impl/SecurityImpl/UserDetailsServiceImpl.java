package com.cm.service.impl.SecurityImpl;

import com.cm.domain.SysUser;
import com.cm.domain.VO.LoginSysUser;
import com.cm.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectSysUserByUserAccount(userAccount);
        if (sysUser==null){
            log.info("登录用户：{} 不存在.", userAccount);
            throw new UsernameNotFoundException("登录用户：" + userAccount + " 不存在");
        }

        return new LoginSysUser(sysUser,"*:*:*");

    }
}
