package com.amdocs.media.assignement.dto;

public class UserProfileDTO {

	private Long id;

	private String address;

	private String phoneNumber;

	private Long userCredId;

	public UserProfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfileDTO(String address, String phoneNumber) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getUserCredId() {
		return userCredId;
	}

	public void setUserCredId(Long userCredId) {
		this.userCredId = userCredId;
	}

	@Override
	public String toString() {
		return "UserProfileDTO [id=" + id + ", address=" + address + ", phoneNumber=" + phoneNumber + ", userCredId="
				+ userCredId + "]";
	}

}
