//package com.example.springsecuritydemo.config;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 9)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//
//
//    //局部配置
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/web/**")
//                .authorizeRequests()
//                .antMatchers("/web/test").hasRole("USER")
//                .and()
//                .formLogin()
//                .and().authorizeRequests()
//                .anyRequest().authenticated();
//    }
//}
