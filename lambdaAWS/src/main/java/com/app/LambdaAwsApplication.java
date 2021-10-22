package com.app;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LambdaAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaAwsApplication.class, args);
	}
	
	@Bean
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}

	
	@Bean
    public Function<String, Boolean> containsCloud() {
        return value -> value.contains("cloud");
    }
	
}
