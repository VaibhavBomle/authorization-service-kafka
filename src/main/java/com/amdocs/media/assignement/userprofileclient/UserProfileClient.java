package com.amdocs.media.assignement.userprofileclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.media.assignement.model.UserProfileDTO;

@FeignClient(name = "userprofile-service",url = "http://localhost:8001")
public interface UserProfileClient {

	@GetMapping("/api/v1/user-profile")
	public UserProfileDTO getUserProfileByUserCredId(@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "userCredId",required = false) Long userCredId);
	
	@PostMapping("/api/v1/userProfile")
	public UserProfileDTO createUserProfile(@RequestBody UserProfileDTO userProfile);
}
