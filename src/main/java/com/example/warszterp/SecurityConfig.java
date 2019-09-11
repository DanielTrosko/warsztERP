package com.example.warszterp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled from user WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/user**").hasAnyRole("USER", "EMPLOYE", "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/employe**").hasAnyRole("EMPLOYE", "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/admin**").hasAnyRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/signin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                    String errMsg = "Correct Login";
                    httpServletRequest.setAttribute("msg", errMsg);
                    httpServletResponse.sendRedirect("/successlogin");
                }))
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    String errMsg;
                    if (e.getClass().isAssignableFrom(BadCredentialsException.class)) {
                        errMsg = "Invalid Username or Password";
                    } else {
                        errMsg = "Unknown error" + e.getMessage();
                    }
                    httpServletRequest.setAttribute("msg", errMsg);
                    httpServletResponse.sendRedirect("/failurelogin");
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/signout")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletRequest.getSession().setAttribute("msg", "You are logged out successfully");
                    httpServletResponse.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .csrf().disable();


    }
}
