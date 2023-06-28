package com.example.proyectoCM;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Controller
public class ProyectoCmApplication {

	@Autowired
	UsuarioRepositorio repository;


	@PostMapping("/usuariosPost")
	public ResponseEntity<Usuario> createUser
			(@RequestBody Usuario user) {

		Usuario newuser = new Usuario(user.getId(), user.getUsuario(),user.getApellido(),user.getEdad(), user.getNombre(), user.getPeso());
		repository.save(newuser);
		return new ResponseEntity<>(newuser, HttpStatus.CREATED);

	}

	@GetMapping("/usuariosGet")
	public ResponseEntity<List<Usuario>> getAllUsers() {

		List<Usuario> users = new ArrayList<Usuario>();
		repository.findAll().forEach(users::add);
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@RequestMapping("/lista")
	@ResponseBody
	public String abrirLista(){
		return "listaUsuarios";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCmApplication.class, args);
	}

}
