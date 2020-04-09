package com.lm.springsecurity.security;

import com.lm.springsecurity.model.LmUserDetails;
import com.lm.springsecurity.model.Role;
import com.lm.springsecurity.repository.RoleRepository;
import com.lm.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleInfo;
import java.util.*;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/6 9:56
 */
@Component
public class LmUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LmUserDetails lmUserDetails = userInfoRepository.findByUserName(username);
        if(lmUserDetails == null) {
            throw  new UsernameNotFoundException("username " + username + " was not found in db.");
        }

        List<Role> roleInfos = roleRepository.findByUserId(lmUserDetails.getId());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role roleInfo: roleInfos) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleInfo.getRoleName());
            grantedAuthorities.add(grantedAuthority);
        }
        lmUserDetails.setAuthorities(grantedAuthorities);
       return lmUserDetails;
    }
}
