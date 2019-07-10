package com.hcl.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rest.api.entity.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Integer> {
	
	public UserRegistration findById(int userId);
	
	

}
