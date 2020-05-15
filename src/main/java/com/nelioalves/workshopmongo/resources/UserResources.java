package com.nelioalves.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired	// o spring já faz a instanciação do objeto
	private UserService service;
	
	// @GetMapping  // forma mais simples
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		// User maria = new User("1", "Maria Brown", "maria@gmail.com");
		// User alex = new User("2", "Alex Silva", "alex@gmail.com");
		// return ResponseEntity.ok().body(Arrays.asList(maria, alex));

		return ResponseEntity.ok().body(service.findAll());
	}
}
