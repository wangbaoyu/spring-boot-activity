package com.activity.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Creted by Administrator on 2018/2/5.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用于排除拦截
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**/*").excludePathPatterns("/user/login");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**/*");
        super.addInterceptors(registry);
    }
}
