package com.demo.TrainingDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.TrainingDemo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
