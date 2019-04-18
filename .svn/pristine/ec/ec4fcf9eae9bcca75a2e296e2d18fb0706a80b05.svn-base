package com.qywx.config;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.qywx.interceptor.SessionInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	@Autowired
	private SessionInterceptor sessionInterceptor;
	
	/**
	 * 静态资源配置
	 */
	/*@Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/img/**")
               .addResourceLocations("classpath:/imgs/");
       
       super.addResourceHandlers(registry);
   }*/


	/**
	 * 默认首页配置
	 */
	/*
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    } */
	
	/**
     * interceptor配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	logger.info("加入session拦截器");
        registry.addInterceptor(sessionInterceptor)
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/api/**")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/api/msg")
                .excludePathPatterns("/index");
    }
    
    /**
	 * 文件上传配置
	 * 
	 * @return MultipartConfigElement
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement(
			@Value("${multipart.maxFileSize}") String maxFileSize,
			@Value("${multipart.maxRequestSize}") String maxRequestSize) {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize(maxFileSize);
		// 设置总上传数据总大小
		factory.setMaxRequestSize(maxRequestSize);
		return factory.createMultipartConfig();
	}


}
