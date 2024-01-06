package com.ecom.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecom.app.enums.UserType;

@Entity
@Table(name = "credential_master")
public class CredentialMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "user_type_id")
	private UserType userTypeId;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "password")
	private String password;
	@Column(name = "user_id")
	private Long userId;
	
	@Transient
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(UserType userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public CredentialMaster(Long id, String name, UserType userTypeId, String email, String phoneNo, String password,
			Long userId) {
		super();
		this.id = id;
		this.name = name;
		this.userTypeId = userTypeId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.userId = userId;
	}

	public CredentialMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean passwordMatches(String password) {
        return (passwordEncoder.matches(password, this.password));
    }
	
	public String passwordEncoder(String password) {
		return passwordEncoder.encode(password);
	}

}
