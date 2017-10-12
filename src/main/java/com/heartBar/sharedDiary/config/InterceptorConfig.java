package com.heartBar.sharedDiary.config;

import com.heartBar.sharedDiary.common.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangxy 2017/9/29 16:05
 */
@Configuration
@ComponentScan(basePackages = "com.heartBar.sharedDiary")
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/*")
                .addPathPatterns("/safeSSL/*")
                .excludePathPatterns("/testFreemarker")
                .excludePathPatterns("/error")
                .excludePathPatterns("/loginView")
                .excludePathPatterns("/register")
                .excludePathPatterns("/login");
        super.addInterceptors(registry);
    }


}
