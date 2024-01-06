package com.ecom.app.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.SignUpRequest;

@Component
public class CustomValidation {

	public CustomResponse checkRegisterUser(SignUpRequest signUpRequest) {
		if(signUpRequest.getEmail() == null)
			return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null, "Please provide Email.");
		if(signUpRequest.getPhoneNo() == null)
			return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null, "Please provide Phone Number.");
		return new CustomResponse(HttpStatus.OK.value(), null, HttpStatus.OK.name());
	}

}
