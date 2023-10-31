package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class BlogSearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogSearchApplication.class, args);
	}
}
