package com.hydu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * Created on 2019/10/12
 * @author heyong
 * 跨域拦截处理
 */

public class GlobalCorsConfig {

//    @Bean
//    public CorsFilter corsFilter(){
//        System.out.println("CorsFilter拦截器进来了");
//        //添加cors配置信息
//        CorsConfiguration config = new CorsConfiguration();
//        //允许的域，不要用*，否则cookie就无法使用
//        config.addAllowedOrigin("http://manage.guoguo.com");
//        //是否发送cookie信息
//        config.setAllowCredentials(true);
//        //允许的请求方式
//        config.addAllowedMethod("*");
////        config.addAllowedMethod("HEAD");
////        config.addAllowedMethod("GET");
////        config.addAllowedMethod("PUT");
////        config.addAllowedMethod("POST");
////        config.addAllowedMethod("DELETE");
////        config.addAllowedMethod("PATCH");
//        // 允许的头信息
//        config.addAllowedHeader("*");
//        //提娜佳映射路径，我们拦截一切请求
//        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/**",config);
//        //返回新的corsFilter
//        return new CorsFilter(configSource);
//    }
}