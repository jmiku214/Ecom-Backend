package com.ecom.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.UserAddressMapDto;
import com.ecom.app.dto.UserAddressMapResponseDto;
import com.ecom.app.model.City;
import com.ecom.app.model.State;
import com.ecom.app.service.CityService;
import com.ecom.app.service.StateService;
import com.ecom.app.service.UserAddressMapService;

@RestController
public class AddressController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;
	
	
	@Autowired
	private UserAddressMapService userAddressMapService;

	@GetMapping("getAll/state")
	public ResponseEntity<?> getAllState() {
		List<State> response = stateService.getAllState();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("getAll/city/{stateId}")
	public ResponseEntity<?> getAllCityByStateId(@PathVariable @Valid Long stateId) {
		List<City> response = cityService.getAllCityByStateId(stateId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("save/address")
	public ResponseEntity<?> saveAddresByUserId(@RequestBody UserAddressMapDto userAddressMapDto) {
		UserAddressMapDto response = userAddressMapService.saveUserAddress(userAddressMapDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@GetMapping("get/address/{userId}")
	public ResponseEntity<?> getAllAddresByUserId(@PathVariable Long userId) {
		List<UserAddressMapResponseDto> response = userAddressMapService.getAllAddressOfAuser(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("update/address")
	public ResponseEntity<?> updateAddresByUserId(@RequestBody UserAddressMapDto userAddressMapDto) {
		UserAddressMapDto response = userAddressMapService.saveUserAddress(userAddressMapDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("get/addresses/{id}")
	public ResponseEntity<?> getByIdAddresByUserId(@PathVariable Long id) {
		UserAddressMapDto response = userAddressMapService.getByIdUserAddress(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PutMapping("delete/address/{id}")
	public ResponseEntity<?> deleteAddresByUserId(@PathVariable Long id) {
		String response = userAddressMapService.removeUserAddress(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
