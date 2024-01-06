package com.ecom.app.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ecom.app.model.City;
import com.ecom.app.model.State;
import com.ecom.app.model.UserAddressMap;
import com.ecom.app.model.UserData;

public class UserAddressMapDto {

	private Long id;

	private Long cityId;

	private Long stateId;

	private Long user;

	private String address;

	private String phone;

	private String name;

	private String nearByLocationAddress;

	private Integer pincode;

	public UserAddressMapDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNearByLocationAddress() {
		return nearByLocationAddress;
	}

	public void setNearByLocationAddress(String nearByLocationAddress) {
		this.nearByLocationAddress = nearByLocationAddress;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public UserAddressMapDto(Long id, Long cityId, Long stateId, Long user, String address, String phone, String name,
			String nearByLocationAddress, Integer pincode) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.stateId = stateId;
		this.user = user;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.nearByLocationAddress = nearByLocationAddress;
		this.pincode = pincode;
	}

	public UserAddressMap convertToUserAddressMap() {
		return new UserAddressMap(this.getId(), new City(this.getCityId()), new State(this.getStateId()),
				new UserData(this.getUser()), this.getAddress(), this.getPhone(), this.getName(),
				this.getNearByLocationAddress(), this.getPincode());
	}

}
