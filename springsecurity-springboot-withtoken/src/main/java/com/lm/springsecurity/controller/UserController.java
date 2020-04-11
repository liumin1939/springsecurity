package com.lm.springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/3 15:41
 */
@RestController
public class UserController {

    @RequestMapping("/user/getUserByName")
    public String hello() {
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String cuurentUser = null;
       if(principal instanceof UserDetails) {
           cuurentUser = ((UserDetails) principal).getUsername();
       } else {
           cuurentUser = principal.toString();
       }

        return cuurentUser + "  say hello to ";
    }
}
