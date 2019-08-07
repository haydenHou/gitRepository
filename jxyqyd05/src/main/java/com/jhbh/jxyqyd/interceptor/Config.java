package com.jhbh.jxyqyd.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * webMvc组件配置
 */
//注明该类是一个配置类，会将结果添加SpringBoot组件中
@Configuration
public class Config implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor())
                .excludePathPatterns("/qy/Login")
                .excludePathPatterns("/qy/loginForPc")
                .excludePathPatterns("/qy/workReg")
                .excludePathPatterns("/qy/changeWorkInfo")
                .addPathPatterns("/qy/*")
                .addPathPatterns("/show");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * 车辆信息登记
         */
        registry.addViewController("/index").setViewName("index");


    }
}
