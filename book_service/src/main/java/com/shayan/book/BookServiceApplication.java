package com.shayan.book;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import com.shayan.book.utils.FileStorageProperties;


@EnableConfigurationProperties({FileStorageProperties.class })
@SpringBootApplication
public class BookServiceApplication  extends MvcConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}


	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public TomcatServletWebServerFactory servletContainerFactory() {
	    return new TomcatServletWebServerFactory() {
	    
	      @Override
	      protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
	          // webapps directory does not exist by default, needs to be created
	          new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
	    
	          // Add a war with given context path
	          // Can add multiple wars this way with different context paths
	         // tomcat.addWebapp("SampleWebApp.war", "target/SampleWebApp.war");
	    
	          return super.getTomcatWebServer(tomcat);
	      }
	    
	    };
	}
	
}
