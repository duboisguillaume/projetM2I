package com.formation.projetM2I.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetM2I.exceptions.UserNotFoundException;
import com.formation.projetM2I.models.User;
import com.formation.projetM2I.repositories.UserRepository;

@RestController
public class MyController {


	private final UserRepository repository;

	public MyController(UserRepository repository) {
		this.repository = repository;
	}

	//renvoie la liste des utilisateurs
	@GetMapping("/users")
	List<User> all() {
		return repository.findAll();
	}

	//ajoute un utilisateurs
	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}

	//renvoie un utilisateur
	@GetMapping("/users/{id}")
	User getUser(@PathVariable Integer id) {

		return repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
	}

	//modifie un utilisateur (a completer)
	@PutMapping("/users/{id}")
	User modifUser(@RequestBody User newUser, @PathVariable Integer id) {

		User u = repository.findById(id).orElse(new User());
		u.setFirstname(newUser.getFirstname());
		return repository.save(u);
	}

	//supprime un utilisateur
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Integer id) {
		repository.deleteById(id);
	}

	//hello world  
	@GetMapping("/")
	String hello(){
		return "Hello World";
	}




}
