package com.koolss.www.matting.config;

import com.koolss.www.matting.constant.RembgConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Description:
 * @Author admin
 * @Date 2021/8/9 10:07
 * @Version 1.0.0
 * @Email koolss@koolss.com
 **/
@Configuration
public class MvcConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/").addResourceLocations("classpath:/static/");
                registry.addResourceHandler("/img/**").addResourceLocations("file:"+ RembgConstant.OUTPUT_PATH);
            }
        };
    }
}
