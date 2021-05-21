package com.shayan.book_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BookManagementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementServerApplication.class, args);
	}

}
