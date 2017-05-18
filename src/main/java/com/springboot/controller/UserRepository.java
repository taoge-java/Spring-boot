package com.springboot.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByName(String name);
}
