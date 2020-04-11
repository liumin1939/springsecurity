package com.lm.springsecurity.security;

import com.lm.springsecurity.model.Role;
import com.lm.springsecurity.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/7 14:03
 */
@Component
@Slf4j
public class LmFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        int index =0;
        if((index = requestUrl.lastIndexOf("?"))>0) {
            requestUrl = requestUrl.substring(0,index);
        }
        log.info("request url:{}",requestUrl);
        List<Role> roles = roleRepository.findByUrl(requestUrl);
        String[] values = new String[roles.size()];
        int i = 0;
        for (Role role : roles) {
            values[i++] = role.getRoleName();
        }
        return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
