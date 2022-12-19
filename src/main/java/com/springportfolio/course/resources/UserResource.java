package com.springportfolio.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springportfolio.course.entities.User;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User("felipe", "felipe@gmail.com", "999999", 1L ,"123456");
		return ResponseEntity.ok().body(u);
	}
	
}
