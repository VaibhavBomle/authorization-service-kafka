package com.amdocs.media.assignement;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.amdocs.media.assignement.model.UserCred;
import com.amdocs.media.assignement.service.UserCredService;

@SpringBootApplication
@EnableFeignClients
public class AssignementApplication {

	@Autowired
	private UserCredService userCredService;
	
	public static void main(String[] args) {
		SpringApplication.run(AssignementApplication.class, args);
	}
	
	@PostConstruct
	private void init() {
		userCredService.createUserCred(new UserCred("admin", "admin"));
	}
	

}
