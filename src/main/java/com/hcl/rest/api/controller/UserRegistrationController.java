package com.hcl.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.api.entity.UserRegistration;
import com.hcl.rest.api.service.ImplUserService;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {
	
	@Autowired
	ImplUserService implUserService;
	
	@PostMapping("/registration")
	public UserRegistration userRegistration(@RequestBody UserRegistration userRegistration)
	{
		return implUserService.userRegistration(userRegistration);
	}
	

}
