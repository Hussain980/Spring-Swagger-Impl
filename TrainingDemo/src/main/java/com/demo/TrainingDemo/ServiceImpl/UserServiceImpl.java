package com.demo.TrainingDemo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.TrainingDemo.Entity.User;
import com.demo.TrainingDemo.Repository.UserRepository;
import com.demo.TrainingDemo.Service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository UserRepository;

	@Override
	public User saveUser(User user) {
		return UserRepository.save(user);
		
	}

	@Override
	public List<User> getUsers() {
		return UserRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		UserRepository.deleteById(id);
		
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return UserRepository.findById(id);
	}

	@Override
	public User updateUser(User user) {
		return UserRepository.save(user);
		
	}

}
