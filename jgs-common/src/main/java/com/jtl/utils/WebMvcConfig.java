package com.jtl.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        /** 本地文件上传路径 */
        registry.addResourceHandler("/img" + "/**").addResourceLocations("file:" + "E:/img" + "/");
    }

    /**
     * 配置拦截器
     * 注册拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
}
