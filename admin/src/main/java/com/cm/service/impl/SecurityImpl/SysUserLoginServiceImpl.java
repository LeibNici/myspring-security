package com.cm.service.impl.SecurityImpl;

import com.cm.domain.VO.LoginSysUser;
import com.cm.service.SysUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServiceImpl tokenService;

    @Override
    public String login(String userAccount, String userPassword) {

        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAccount,userPassword));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        LoginSysUser loginSysUser = (LoginSysUser) authentication.getPrincipal();
        return tokenService.createToken(loginSysUser);
    }
}
