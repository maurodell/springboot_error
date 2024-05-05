package com.example.springboot.error.Spring.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor loadingTimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loadingTimeInterceptor).addPathPatterns("/app/interceptor/foo", "/app/interceptor/baz");
        //registry.addInterceptor(loadingTimeInterceptor).addPathPatterns("/app/**");
        //registry.addInterceptor(loadingTimeInterceptor).excludePathPatterns("/app/interceptor/foo");
    }
}
