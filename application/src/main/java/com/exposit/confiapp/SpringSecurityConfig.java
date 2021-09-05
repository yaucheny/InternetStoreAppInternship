package com.exposit.confiapp;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Class to configure spring security.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles(USER)
                .and()
                .withUser("admin").password("{noop}password").roles(ADMIN);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/**").hasRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/**").hasRole(ADMIN)
                .antMatchers(HttpMethod.PATCH, "/**").hasRole(ADMIN)
                .antMatchers(HttpMethod.DELETE, "/**").hasRole(ADMIN)
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated().
                and().
                csrf().disable();
    }
}
