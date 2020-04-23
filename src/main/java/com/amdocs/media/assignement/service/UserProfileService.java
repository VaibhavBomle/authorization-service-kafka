package com.amdocs.media.assignement.service;

import com.amdocs.media.assignement.model.UserProfileDTO;

public interface UserProfileService {

	UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO);
	
	UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO);
	
	void deleteUserProfileById(Long id);
}
