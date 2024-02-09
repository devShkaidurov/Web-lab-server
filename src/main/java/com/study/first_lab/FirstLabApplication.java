package com.study.first_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstLabApplication.class, args);
	}

}

// где точка входа в приложение
// мысами создаем 404 ошибки?
// @AutoWired - автомматичсеское внедрение зависиомстей
// через конструктор
// @componetn - бин (servis, repository, controller)