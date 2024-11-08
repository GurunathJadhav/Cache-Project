package com.cacheproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheProjectApplication.class, args);
	}

}
