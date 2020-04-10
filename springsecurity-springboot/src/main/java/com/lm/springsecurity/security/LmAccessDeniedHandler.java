package com.lm.springsecurity.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/10 10:55
 */
@Component
public class LmAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("权限不足，请联系管理员.");
        out.flush();
        out.close();
    }
}
