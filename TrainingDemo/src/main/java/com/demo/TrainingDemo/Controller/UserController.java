package com.demo.TrainingDemo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.TrainingDemo.Entity.User;
import com.demo.TrainingDemo.Exception.UserNotFoundException;
import com.demo.TrainingDemo.Service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

//	@GetMapping("/test")
//	public String test() {
//		return "welcome";
//	}

	// get All Users
	@GetMapping
	@ApiOperation(value = "Getting all users")
	public List<User> getAllUsers() {
		log.info("This is logging code ");
		return userService.getUsers();

	}

	// get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User Not found with id " + id));

	}

	// create user
	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);

	}

	// delete by userid
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		User userdb =	 userService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User Not found with id " + id));
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

	// update user
	@PutMapping("/{id}")
	public User updateUser(@Valid @RequestBody User user,@PathVariable Long id) {
	User userdb =	 userService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User Not found with id " + id));
	userdb.setEmail(user.getEmail());
	userdb.setFirstName(user.getFirstName());
	userdb.setLastName(user.getLastName());
		return userService.updateUser(userdb);
	}
}
