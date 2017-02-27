package com.architecture.em.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;

@Configuration
@EnableWebMvc
//设置扫描路径
@ComponentScan({"com.architecture.em"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServletConfig extends WebMvcConfigurerAdapter {

    @Inject
    private EmInterceptor emInterceptor;

    // 添加 default servlet 支持
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.emInterceptor).addPathPatterns("/api/**");
    }
}
