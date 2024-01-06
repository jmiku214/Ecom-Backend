package com.ecom.app.service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.ForgetPasswordRequestDto;
import com.ecom.app.dto.LoginRequest;
import com.ecom.app.dto.LoginResponse;
import com.ecom.app.dto.SignUpRequest;

public interface UserService {

	LoginResponse login(LoginRequest loginRequest) throws Exception;

	CustomResponse registerUser(SignUpRequest signUpRequest);

	CustomResponse forgetPassword(ForgetPasswordRequestDto forgetPassword);

	void otpGenerator(String email);

}
