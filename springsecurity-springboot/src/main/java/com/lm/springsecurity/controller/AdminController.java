package com.lm.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/3 15:41
 */
@RestController
public class AdminController {

    @RequestMapping("/admin/getUserByName")
    public String hello(String username) {
        return " admin hello "+ username;
    }
}
