package com.hydu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created on 2019/10/12
 *
 * @author heyong
 */
@Configuration
public class CrossRequestInterapter extends WebMvcConfigurationSupport {

    @Autowired
    private CORSFilter corsFilter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsFilter)
                //拦截所有的请求
                .addPathPatterns("/**");

    }
}