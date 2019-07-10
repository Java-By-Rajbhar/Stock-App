package com.hcl.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rest.api.entity.UserRegistration;
import com.hcl.rest.api.repository.UserRepository;

@Service
public class ImplUserService implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserRegistration userRegistration(UserRegistration userRegistration) {
		
		return userRepository.save(userRegistration);
		
	}

}
