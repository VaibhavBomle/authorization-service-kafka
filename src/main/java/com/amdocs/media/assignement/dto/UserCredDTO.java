package com.amdocs.media.assignement.dto;

public class UserCredDTO {

	private Long id;
	private String username;

	private String password;

	public UserCredDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	
}
