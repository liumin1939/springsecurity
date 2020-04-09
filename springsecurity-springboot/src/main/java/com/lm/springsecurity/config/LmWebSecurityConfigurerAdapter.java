package com.lm.springsecurity.config;

import com.lm.springsecurity.security.LmAccessDecisionManager;
import com.lm.springsecurity.security.LmFilterInvocationSecurityMetadataSource;
import com.lm.springsecurity.security.LmUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/3 16:19
 */
@Configuration
@EnableWebSecurity
public class LmWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private LmUserDetailsService userDetailsService;

    @Autowired
    private LmFilterInvocationSecurityMetadataSource lmFilterInvocationSecurityMetadataSource;
    @Autowired
    private LmAccessDecisionManager lmAccessDecisionManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123456")
//                .roles("ADMIN","USER")
//                .and()
//                .withUser("lm")
//                .password("{noop}123456")
//                .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(lmFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(lmAccessDecisionManager);
                        return o;
                    }
                })
//                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/h2/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().and()
                .formLogin();

        http.csrf().ignoringAntMatchers("/h2/**");
        http.headers().frameOptions().sameOrigin();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}
