package com.cm.service.impl.SecurityImpl;

import com.cm.domain.VO.LoginSysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl {

    /**
     * 根据loginsysuser创建token令牌
     *
     * @param loginSysUser
     * @return
     */
    public String createToken(LoginSysUser loginSysUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userAccount", loginSysUser.getUsername());
        claims.put("userPassword", loginSysUser.getPassword());
        String token = Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "admin")
                .compact();
        return token;
    }

    public LoginSysUser getLoginSysUser(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if (token != null) {
            token = token.replace("Bearer", "");
            Claims claims = Jwts.parser().setSigningKey("admin").parseClaimsJws(token).getBody();
            System.out.println(claims);
        }
        return null;
    }

}
