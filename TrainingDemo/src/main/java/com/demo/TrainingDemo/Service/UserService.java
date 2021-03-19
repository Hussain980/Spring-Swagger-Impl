package com.demo.TrainingDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.TrainingDemo.Entity.User;


@Service
public interface UserService {

	public User saveUser(User user);
	
	public List<User> getUsers();
	
	public void deleteUser(Long id);
	
	public Optional<User> getUserById(Long id);
	
	public User updateUser(User user);
}
