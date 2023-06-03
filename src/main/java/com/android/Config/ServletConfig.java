package com.android.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = { "com.android.Controller", "com.android.exception" })
public class ServletConfig implements WebMvcConfigurer {

//		@Override
//		public void configureViewResolvers(ViewResolverRegistry registry) {
//			// TODO Auto-generated method stub
//			InternalResourceViewResolver bean = new InternalResourceViewResolver();
//			bean.setViewClass(JstlView.class);
//			bean.setPrefix("/WEB-INF/views/");
//			bean.setSuffix(".jsp");
//			registry.viewResolver(bean);
//		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			// TODO Auto-generated method stub
			WebMvcConfigurer.super.addResourceHandlers(registry);
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
			registry.addResourceHandler("/img/**").addResourceLocations("");
		}

		@Bean
		public MultipartResolver multipartResolver() {
			StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
			return resolver;
		}

}
