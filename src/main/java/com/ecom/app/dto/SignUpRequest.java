package com.ecom.app.dto;

public class SignUpRequest {

	private String email;
	private String userName;
	private String phoneNo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpRequest(String email, String userName, String phoneNo) {
		super();
		this.email = email;
		this.userName = userName;
		this.phoneNo = phoneNo;
	}

}
