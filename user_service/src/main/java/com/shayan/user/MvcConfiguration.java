package com.shayan.user;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfiguration  implements  WebMvcConfigurer  
{
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Register resource handler for images
		
		  registry.addResourceHandler("/uploads/**").addResourceLocations(
		  "/WEB-INF/uploads/");
		  registry.addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
		
		/*
		 * registry .addResourceHandler("/uploads/**") .addResourceLocations("file:" +
		 * n.getUploadDir()) .setCachePeriod(3600) .resourceChain(true) .addResolver(new
		 * PathResourceResolver());
		 */
	}
	
	
	

	
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	registry.jsp("/WEB-INF/view/", ".jsp");
    }


}