package com.amdocs.media.assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.amdocs.media.assignement.model.UserProfileDTO;
import com.amdocs.media.assignement.userprofileclient.UserProfileClient;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private KafkaTemplate<String, UserProfileDTO> kafkaTemplate;
	
	@Autowired
	private UserProfileClient userProfileClient;
	
	@Override
	public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
		return userProfileClient.createUserProfile(userProfileDTO);
	}

	@Override
	public UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO) {
		kafkaTemplate.send("updateUserProfile", userProfileDTO);
		return userProfileClient.getUserProfileByUserCredId(userProfileDTO.getId(), null);
	}

	@Override
	public void deleteUserProfileById(Long id) {
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setId(id);
		kafkaTemplate.send("deleteUserProfile", userProfileDTO);
		
	}
	
	

}
