package com.ecom.app.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ecom.app.model.City;
import com.ecom.app.model.State;
import com.ecom.app.model.UserAddressMap;
import com.ecom.app.model.UserData;

public class UserAddressMapResponseDto {

	private Long id;

	private String address;

	public UserAddressMapResponseDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public UserAddressMapResponseDto(Long id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

}
