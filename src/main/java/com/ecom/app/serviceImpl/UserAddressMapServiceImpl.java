package com.ecom.app.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.UserAddressMapDto;
import com.ecom.app.dto.UserAddressMapResponseDto;
import com.ecom.app.model.UserAddressMap;
import com.ecom.app.repository.UserAddressMapRepository;
import com.ecom.app.service.UserAddressMapService;

@Service
public class UserAddressMapServiceImpl implements UserAddressMapService {

	@Autowired
	private UserAddressMapRepository userAddressMapRepository;

	@Override
	public UserAddressMapDto saveUserAddress(UserAddressMapDto userAddressMapDto) {
		UserAddressMap userAddressMap = userAddressMapDto.convertToUserAddressMap();
		UserAddressMapDto saveResponse = userAddressMapRepository.save(userAddressMap).convertUserAddressMapDto();
		return saveResponse;
	}

	@Override
	public List<UserAddressMapResponseDto> getAllAddressOfAuser(Long userId) {
		try {
			List<UserAddressMap> userAddressMaps = userAddressMapRepository.findByUserId(userId);
			List<UserAddressMapResponseDto> userAddressMapResponseDtoList = userAddressMaps.stream()
					.map(e -> e.convertToUserAddressMapResponseDto()).collect(Collectors.toList());
			return userAddressMapResponseDtoList;
		} catch (Exception e) {
			return Arrays.asList(new UserAddressMapResponseDto(userId, null));
		}
	}
	
	@Override
	public UserAddressMapDto updateUserAddress(UserAddressMapDto userAddressMapDto) {
		UserAddressMap userAddressMap = userAddressMapDto.convertToUserAddressMap();
		UserAddressMapDto updateResponse = userAddressMapRepository.save(userAddressMap).convertUserAddressMapDto();
		return updateResponse;
	}
	
	@Override
	public UserAddressMapDto getByIdUserAddress(Long id) {
		UserAddressMap getById = userAddressMapRepository.findById(id).get();
		UserAddressMapDto getByIdResponse = getById !=null ? getById.convertUserAddressMapDto():null;
		return getByIdResponse;
	}
	
	@Override
	public String removeUserAddress(Long id) {
		userAddressMapRepository.deleteById(id);
		return "Address Delete Successfuly!!!";
	}

}
