package com.smart.village.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.smart.village.model.HospitlInformation;
import com.smart.village.model.User;
import com.smart.village.repository.HospitalInfoRepo;
import com.smart.village.repository.UserRepo;

@RestController
public class SearchController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private  HospitalInfoRepo hospitalInfoRepo;
	
	

	
	//search handler
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query,Principal principal)
	{
		System.out.println(query);		
		User user=this.userRepo.getUserByUserName(principal.getName());		
		List<HospitlInformation> contacts = this.hospitalInfoRepo.findByNameContainingAndUser(query, user);
		return ResponseEntity.ok(contacts);
	}
	
}
