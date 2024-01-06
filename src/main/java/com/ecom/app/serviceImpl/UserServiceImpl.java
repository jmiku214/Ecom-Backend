package com.ecom.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.ForgetPasswordRequestDto;
import com.ecom.app.dto.LoginRequest;
import com.ecom.app.dto.LoginResponse;
import com.ecom.app.dto.SignUpRequest;
import com.ecom.app.enums.UserType;
import com.ecom.app.exception.UnauthorizedException;
import com.ecom.app.model.CredentialMaster;
import com.ecom.app.model.EmailOtp;
import com.ecom.app.model.UserData;
import com.ecom.app.repository.CredentialMasterRepository;
import com.ecom.app.repository.EmailOtpRepository;
import com.ecom.app.repository.UserDataRepository;
import com.ecom.app.security.JwtTokenUtil;
import com.ecom.app.security.JwtUserDetailsService;
import com.ecom.app.service.EmailServiceVM;
import com.ecom.app.service.UserService;
import com.ecom.app.util.GenerateRandomCode;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private CredentialMasterRepository credentialMasterRepository;

	@Autowired
	private UserDataRepository userDataRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private EmailServiceVM emailServiceVM;

	@Autowired
	private EmailOtpRepository emailOtpRepository;
	

	@Override
	public LoginResponse login(LoginRequest loginRequest) throws Exception {
		LoginResponse loginResponse = new LoginResponse();

		UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		if (userDetails != null) {

			Optional<CredentialMaster> credentialMasterOptional = credentialMasterRepository
					.findByEmail(loginRequest.getUsername());

			if (credentialMasterOptional.isPresent()) {

				CredentialMaster credentialMaster = credentialMasterOptional.get();

				if (credentialMaster.passwordMatches(loginRequest.getPassword())) {
					for (UserType userType : UserType.values()) {
						if (credentialMaster.getUserTypeId().name().equalsIgnoreCase(userType.name())) {
							loginResponse.setId(credentialMaster.getId());
							loginResponse.setEmail(credentialMaster.getEmail());
							loginResponse.setUserName(credentialMaster.getName());
							loginResponse.setUserType(credentialMaster.getUserTypeId().name());
							loginResponse.setToken(jwtTokenUtil.generateToken(userDetails));
						}
					}

				} else {
					throw new UnauthorizedException("INVALID_CREDENTIALS");
				}
			}

			return loginResponse;
		} else {
			throw new Exception("Invalid Credential");
		}
	}

	@Override
	@Transactional
	public CustomResponse registerUser(SignUpRequest signUpRequest) {
		try {
			List<CredentialMaster> credentialMasterDBList = credentialMasterRepository
					.findAllByPhoneNoEmail(signUpRequest.getPhoneNo(), signUpRequest.getPhoneNo());
			for (CredentialMaster credentialMaster : credentialMasterDBList) {
				if (credentialMaster.getEmail() != null && credentialMaster.getPhoneNo() != null
						&& (credentialMaster.getEmail().equals(signUpRequest.getEmail())
								|| credentialMaster.getPhoneNo().equals(signUpRequest.getPhoneNo())))
					return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null,
							"Email and phone number cannot be duplicate !!!");
			}
			String defaultPassword=GenerateRandomCode.randomString(8);
			emailServiceVM.sendNewWelcomeLetter("Welcome to Ecom Portal", signUpRequest.getEmail(),
					defaultPassword, signUpRequest.getUserName());
			CredentialMaster credentialMasterSave = new CredentialMaster(null, signUpRequest.getUserName(),
					UserType.Customer, signUpRequest.getEmail(), signUpRequest.getPhoneNo(), null, null);

			credentialMasterSave.setPassword(credentialMasterSave.passwordEncoder(defaultPassword));
			UserData userDataSave = new UserData(null, signUpRequest.getUserName(), signUpRequest.getEmail(),
					signUpRequest.getPhoneNo(), true);
			userDataSave = userDataRepository.save(userDataSave);
			credentialMasterSave.setUserId(userDataSave.getId());
			credentialMasterSave = credentialMasterRepository.save(credentialMasterSave);
			if (credentialMasterSave != null)
				return new CustomResponse(HttpStatus.OK.value(), credentialMasterSave,
						"User Registered Succefully  !!!");
			else
				return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null, "Failed in User Registeration!!!");

		} catch (Exception e) {
			return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null,
					"Register user service goes wrong.");
		}
	}

	private String generatePassword() {
		
		return null;
	}

	@Override
	public CustomResponse forgetPassword(ForgetPasswordRequestDto forgetPassword) {
		Optional<CredentialMaster> userData = credentialMasterRepository.findByEmail(forgetPassword.getEmail());
		Optional<EmailOtp> otp = emailOtpRepository.findByEmail(forgetPassword.getEmail());
		if (userData != null && userData.isPresent()) {
			if (otp.get().getOtp().equals(forgetPassword.getOtp())) {
				if (forgetPassword.getPassword().equals(forgetPassword.getRetypePassword())) {
					userData.get().setPassword(userData.get().passwordEncoder(forgetPassword.getPassword()));
				}
			}else {
				return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null, "Enter a valid otp !!!!");
			}

		}
		CustomResponse response = new CustomResponse();
		CredentialMaster master = credentialMasterRepository.save(userData.get());
		response.setMessage("Password Reset Succesful..");
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

	@Override
	@Transactional
	public void otpGenerator(String email) {
		Optional<CredentialMaster> emaiFound = credentialMasterRepository.findByEmail(email);
		String.valueOf(GenerateRandomCode.getRandomNumber(111111, 999999));
		Optional<EmailOtp> otp = emailOtpRepository.findByEmail(email);
		EmailOtp generatedOtp = new EmailOtp();
		if(otp.isPresent()) {
			generatedOtp = otp.get();
			generatedOtp.setOtp(String.valueOf(GenerateRandomCode.getRandomNumber(111111, 999999)));
			
		}else {
			generatedOtp = new EmailOtp(null, email, String.valueOf(GenerateRandomCode.getRandomNumber(111111, 999999)));
		}
		generatedOtp = emailOtpRepository.save(generatedOtp);
		if (emaiFound.isPresent()) {
			emailServiceVM.sendOtp("Forget password OTP For Ecom Portal", email, generatedOtp.getOtp());
		} else {
			throw new RuntimeException("Enter a valid Email!!!");
		}
	}

}
