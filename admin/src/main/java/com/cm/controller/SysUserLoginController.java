package com.cm.controller;

import com.cm.domain.SysUser;
import com.cm.service.SysUserLoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysUserLoginController {

    @Autowired
    private SysUserLoginService sysUserLoginService;

    @PostMapping("/login")
    public String login(@RequestBody SysUser sysUser){
        String token = sysUserLoginService.login(sysUser.getUserAccount(),sysUser.getUserPassword());
        return token;
    }

    @GetMapping("/getpassword")
    public void getPassword(@RequestBody SysUser sysUser){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode(sysUser.getUserPassword());
        System.out.println(encodePassword);
        System.out.println(sysUser.getUserPassword());
    }

    @GetMapping("/encode")
    public void encode(){
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey("admin")
                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyUGFzc3dvcmQiOiIkMmEkMTAkVmp0eGNhTjRzcDFuTUI1ek1qcXNadXVFL0w2dzFvZW5RYVZuRGE0UTJrTVB6ZnNzSjFpZ2EiLCJ1c2VyQWNjb3VudCI6ImNtIn0.BOycFC8tu6s7tOesM8VBa_lanL5S8HFjTR0TVUzXq6W9BiJxI3fZq5zAWF_VUco5VQbVRlXxQ6K9aBujQ_-dmg");
        System.out.println(claimsJws);
    }

}
