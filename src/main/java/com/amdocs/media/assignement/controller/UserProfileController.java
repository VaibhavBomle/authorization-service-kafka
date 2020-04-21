package com.amdocs.media.assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.media.assignement.model.UserProfile;

@RestController
public class UserProfileController {
	
	@Autowired
	private KafkaTemplate<String, UserProfile> kafkaTemplate;
	
	@PostMapping("/createUserProfile")
	public String createUserProfile(@RequestBody UserProfile userProfile){
		System.out.println("user profile is going to create");
		kafkaTemplate.send("createUserProfile", userProfile);
		System.out.println("user profile created");
		return "userCreated";
	}

}
