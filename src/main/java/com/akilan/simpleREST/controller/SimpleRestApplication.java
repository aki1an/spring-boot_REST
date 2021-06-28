package com.akilan.simpleREST.controller;

import java.util.ArrayList;

import com.akilan.simpleREST.entity.Profile;
import com.akilan.simpleREST.model.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SimpleRestApplication {

	private static final Model db = new Model();

	@GetMapping("/users")
	public static ArrayList<Profile> getUsers() {
		return db.listOfUsers();
	}
	@GetMapping("/user/{id}")
	public static Profile getUser(@PathVariable("id") int id) {
		return db.specificUser(id);
	}
	@PostMapping("/upload")
	public static String postUser(@RequestBody Profile profile){
		return db.uploadUser(profile);
	}
	@DeleteMapping("/user/{id}")
	public static String deleteUser(@PathVariable("id")int id){
		return db.deleteUser(id);
	}
	@PutMapping("/user/{id}")
	public static String updateUser(@PathVariable("id")int id ,@RequestBody Profile pro){
		return db.updateUser(id,pro);
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(SimpleRestApplication.class, args);
	}

}
