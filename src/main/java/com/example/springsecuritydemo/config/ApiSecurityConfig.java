//package com.example.springsecuritydemo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
//
//@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
//public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    UserDetailsManager userDetailsManager;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
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
//        http.antMatcher("/api/**")
//                .authorizeRequests()
//                .antMatchers("/api/test").hasRole("USER").anyRequest().authenticated().and()
//                .exceptionHandling()
////                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .authenticationEntryPoint(new DigestAuthenticationEntryPoint())
//        ;
//    }
//}
