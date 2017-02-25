package com.architecture.em.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

@Configuration
public class DispatcherServletFilter extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(new LogbackConfigListener());

        // CharacterEncodingFilter 过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        FilterRegistration.Dynamic characterEncodingConfig = servletContext.addFilter(
                "characterEncodingFilter", characterEncodingFilter
        );
        characterEncodingConfig.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),// 这里限定所有客户端请求、服务器 forward、服务器 include 的请求全都需要经过 filter 处理
                false, // 在所有当前已经被声明的 Filter 的前面先匹配 URL
                "/*"
        );


    }

    /**
     * logback 监听器
     */

}
