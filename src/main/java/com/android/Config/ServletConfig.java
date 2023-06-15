package com.android.Config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.AbstractXmlHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.log4j.Log4j;

@EnableWebMvc
@ComponentScan(basePackages = { "com.android.Controller", "com.android.exception" })
@Log4j
public class ServletConfig implements WebMvcConfigurer {
	
		@Override
		public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
//			reorderXmlConvertersToEnd(converters);
			converters.forEach(converter -> log.info(converter));
			
		}
		
		private void reorderXmlConvertersToEnd(List<HttpMessageConverter<?>> converters) {
			List<HttpMessageConverter<?>> xml = new ArrayList<>();
			for(Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
					iterator.hasNext();) {
				HttpMessageConverter<?> converter = iterator.next();
				if((converter instanceof AbstractXmlHttpMessageConverter) || (converter instanceof MappingJackson2XmlHttpMessageConverter)) {
					xml.add(converter);
					iterator.remove();
				}
			}
			converters.addAll(xml);
			
		}
		
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
