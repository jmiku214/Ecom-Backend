package com.ecom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.ForgetPasswordRequestDto;
import com.ecom.app.dto.LoginRequest;
import com.ecom.app.dto.LoginResponse;
import com.ecom.app.dto.SignUpRequest;
import com.ecom.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/v1/signIn", method = RequestMethod.POST)
	public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest) throws Exception {

		LoginResponse loginResponse = userService.login(loginRequest);

		return new ResponseEntity<>(loginResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/v1/signUp", method = RequestMethod.POST)
	public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) throws Exception {

		CustomResponse customResponse = userService.registerUser(signUpRequest);

		return new ResponseEntity<>(customResponse, HttpStatus.valueOf(customResponse.getStatus()));

	}
	
	@PostMapping("/v1/forgetPassword")
	private ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordRequestDto forgetPassword){
		CustomResponse response=userService.forgetPassword(forgetPassword);
		return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatus()));
	}
	
	@PostMapping("/v1/generateOtp")
	private ResponseEntity<?> generateOtp(@RequestBody String email){
		userService.otpGenerator(email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
