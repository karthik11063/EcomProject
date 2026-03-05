package com.Karthik.EcomDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EcomDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomDemoApplication.class, args);
	}

}
