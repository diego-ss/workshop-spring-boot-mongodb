package com.diegoss.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegoss.workshopmongo.domain.User;
import com.diegoss.workshopmongo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserService() {
		
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
