package com.ecom.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecom.app.dto.UserAddressMapDto;
import com.ecom.app.dto.UserAddressMapResponseDto;

@Entity
@Table(name = "user_address_map")
public class UserAddressMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	@OneToOne
	@JoinColumn(name = "state_id")
	private State state;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserData user;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "name")
	private String name;

	@Column(name = "near_by_loaction_address")
	private String nearByLocationAddress;

	@Column(name = "pincode")
	private Integer pincode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
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

	public UserAddressMap(Long id, City city, State state, UserData user, String address, String phone, String name,
			String nearByLocationAddress, Integer pincode) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.user = user;
		this.address = address;
		this.phone = phone;
		this.name = name;
		this.nearByLocationAddress = nearByLocationAddress;
		this.pincode = pincode;
	}

	public UserAddressMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddressMap(Long id) {
		this.id=id;
	}

	public UserAddressMapDto convertUserAddressMapDto() {
		return new UserAddressMapDto(this.getId(),
				this.getCity() != null && this.getCity().getId() != null ? this.getCity().getId() : null,
				this.getState() != null && this.getState().getId() != null ? this.getState().getId() : null,
				this.getUser() != null && this.getUser().getId() != null ? this.getUser().getId() : null,
				this.getAddress(), this.getPhone(), this.getName(), this.getNearByLocationAddress(), this.getPincode());
	}

	public UserAddressMapResponseDto convertToUserAddressMapResponseDto() {

		return new UserAddressMapResponseDto(this.getId() != null ? this.getId() : null,
				(this.getName() + ", " + this.getAddress() + ", " + this.getCity().getCityName() + ", "
						+ this.getState().getStateName() + ", " + this.getNearByLocationAddress() + ", "
						+ this.getPhone() + ", " + +this.getPincode()).toString());
	}
}
