package com.example.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsManager userDetailsManager;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()                      //请求路径"/"允许访问
                .anyRequest().authenticated()                      //其它请求都需要校验才能访问
                .and()
                .formLogin()
                .loginPage("/login")                             //定义登录的页面"/login"，允许访问
                .permitAll()
                .and()
                .logout()                                           //默认的"/logout", 允许访问
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new MyAuthenticationProvider()).userDetailsService(userDetailsManager)
//                .addObjectPostProcessor(new ObjectPostProcessor<DaoAuthenticationProvider>() {
//            @Override
//            public <O extends DaoAuthenticationProvider> O postProcess(O provider) {
//                try {
//                    UserCache userCache = new SpringCacheBasedUserCache(cacheManager.getCache("userCache"));
//                    provider.setUserCache(userCache);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                return provider;
//            }
//        })
        ;
    }

    class MyAuthenticationProvider implements AuthenticationProvider {
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            System.out.println("=============MyAuthenticationProvider authenticate invoke");
            return null;
        }

        @Override
        public boolean supports(Class<?> authentication) {
            System.out.println("================MyAuthenticationProvider supports check");
            return true;
        }
    }
}
