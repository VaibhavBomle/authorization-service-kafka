package com.amdocs.media.assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.assignement.dao.UserCredRepository;
import com.amdocs.media.assignement.model.UserCred;

@Service
public class UserCredServiceImpl implements UserCredService{

	@Autowired
	private UserCredRepository userCredRepository;
	
	@Override
	public UserCred createUserCred(UserCred userCred) {
		return userCredRepository.save(userCred);
	}
	
	@Override
	public UserCred getUserCredById(Long id) {
		return userCredRepository.getOne(id);
	}

	@Override
	public UserCred getUserCredByUserNameAndpassword(String username, String password) {
		return userCredRepository.getByUserNameAndPassword(username, password);
	}
	
	

}
