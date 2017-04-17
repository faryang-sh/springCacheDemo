package com.springcachetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableCaching
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringcachetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcachetestApplication.class, args);
	}
}
