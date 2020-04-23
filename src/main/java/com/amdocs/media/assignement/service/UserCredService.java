package com.amdocs.media.assignement.service;

import com.amdocs.media.assignement.model.UserCred;

public interface UserCredService  {

	UserCred createUserCred(UserCred userCred);
	
	UserCred getUserCredById(Long id);
	
	UserCred getUserCredByUserNameAndpassword(String username,String password);
}
