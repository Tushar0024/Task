package com.example.LoginController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.Login;
import com.example.LoginService.LoginService;

@RestController
@RequestMapping("api/User")
public class LoginController {
	@Autowired
	private LoginService service;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<>(service.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<?>getUserById(@PathVariable int Id){
		return new ResponseEntity<>(service.getUserById(Id),HttpStatus.OK);
	}
	
	@GetMapping("/Email/{EmailID}")
	public ResponseEntity<Login>getUserByEmailID(@PathVariable String EmailID){
		Optional <Login> login = service.getUserByEmailID(EmailID);
		if(login.isPresent()) {
			return ResponseEntity.ok(login.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
			
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody Login l){
		return new ResponseEntity<>(service.saveUser(l),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<?> updateUser(@RequestBody Login l,@PathVariable int Id){
		return new ResponseEntity<>(service.updateUser(l, Id),HttpStatus.CREATED);
	}
	@DeleteMapping("/{Id}")
	public void deleteUser(@PathVariable int Id){
		service.deleteUser(Id);
	}
	
}
