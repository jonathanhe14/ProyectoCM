package com.example.proyectoCM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProyectoCmApplication {

	@GetMapping("/Hola")
	public String hola(){
		return"Hola mundo";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCmApplication.class, args);
	}

}
