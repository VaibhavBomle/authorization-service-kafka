package com.amdocs.media.assignement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CRED")
public class UserCred {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;

	private String password;

	public UserCred() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserCred(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "UserCred [userName=" + userName + ", password=" + password + ", id=" + id + "]";
	}

}
