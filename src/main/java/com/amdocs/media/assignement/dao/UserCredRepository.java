package com.amdocs.media.assignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.media.assignement.model.UserCred;

@Repository
public interface UserCredRepository extends JpaRepository<UserCred, Long> {
	
	UserCred getByUserNameAndPassword(String username,String password); 

}
