package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.UserAddressMapDto;
import com.ecom.app.dto.UserAddressMapResponseDto;

public interface UserAddressMapService {

	UserAddressMapDto saveUserAddress(UserAddressMapDto userAddressMapDto);

	List<UserAddressMapResponseDto> getAllAddressOfAuser(Long userId);

	UserAddressMapDto updateUserAddress(UserAddressMapDto userAddressMapDto);

	UserAddressMapDto getByIdUserAddress(Long id);

	String removeUserAddress(Long id);

}
