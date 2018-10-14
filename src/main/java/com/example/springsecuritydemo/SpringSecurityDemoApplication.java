package com.example.springsecuritydemo;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.authentication.CachingUserDetailsService;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@SpringBootApplication
@EnableCaching
public class SpringSecurityDemoApplication {



//    @Bean(name = "userCacheManager")
//    public CacheManager userCacheManager(JdbcUserDetailsManager userDetailsManager) throws Exception {
//
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager("userCache");
//        UserCache userCache = new SpringCacheBasedUserCache(cacheManager .getCache("userCache"));
//        userDetailsManager.setUserCache(userCache);
//        CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>() {
//            @Override
//            public Object load(Object key) throws Exception {
//                System.out.println("不走缓存");
//                return userDetailsManager.loadUserByUsername(key.toString());
//            }
//        };
//
//        cacheManager.setCacheLoader(cacheLoader);
//        //每分钟刷新,五条的每个冷启动数据集大概都有2万条数据 maximumSize 指key的数量 非 value 的容量
////        cacheManager.setCacheSpecification(appPrefixConfig.getCacheSpecification(WUTIAO_HOT_COLD_RCMD_CACHE_MANAGER));
//        return cacheManager;
//
//
//    }


    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) throws Exception {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        UserCache userCache = new SpringCacheBasedUserCache(userCacheManager() .getCache("userCache"));
//        userDetailsManager.setUserCache(userCache);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    //全局配置
    @Autowired
    public void globalInitialize(AuthenticationManagerBuilder builder, DataSource dataSource) throws Exception {
//        builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
//                .withUser("dave")
//                .password("secret").roles("USER");
        builder.userDetailsService(userDetailsManager(dataSource)).passwordEncoder(passwordEncoder());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }
}
