package com.lm.springsecurity.controller;

import com.lm.springsecurity.security.LmUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/10 12:20
 */
@RestController
public class TokenManangerController {
    private AuthenticationManager authenticationManager;
    @Autowired
    LmUserDetailsService lmUserDetailsService;
    public Token authorize(String useranem,String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(useranem,password);
        Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = this.lmUserDetailsService.loadUserByUsername(useranem);
        return null;
    }
}
