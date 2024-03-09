package com.study.first_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
public class FirstLabApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstLabApplication.class, args);
	}

}
