package com.ssafy.happyhouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.common.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	// step 1 - board-vue
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginInterceptor)
//		.addPathPatterns("/**")
//		.excludePathPatterns(
//				"/",
//				"/index.html", 
//				"/favicon.ico", 
//				"/css/**", 
//				"/js/**",
//				"/login/**"); // static folder
//	}

	// step 2 - board-vue-vuex
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns(
				"/",
				"/index.html", 
				"/favicon.ico", 
				"/css/**", 
				"/js/**",
				"/codes/**",
				"/login/**", 
				"/user/**",
				"/bookmark/**",
				"/bookmarkArea/**"); // static folder
	}
}
