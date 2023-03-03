package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dao", "entities", "web"})

public class ProjectGrShopInscriptionSpringMicroServApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGrShopInscriptionSpringMicroServApplication.class, args);
	}
	
	CommandLineRunner start() {
		return args -> {      
		};
	}

}
