package com.example.proyecto_x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class ProyectoXApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoXApplication.class, args);
	}

}