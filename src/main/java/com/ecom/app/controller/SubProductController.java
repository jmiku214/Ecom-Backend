package com.ecom.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.SubProductAllDetailsDto;
import com.ecom.app.dto.SubProductDto;
import com.ecom.app.service.SubProductService;

@RestController
public class SubProductController {

	@Autowired
	private SubProductService subProductService;

	@PostMapping("add/subProduct")
	public ResponseEntity<?> saveSubProductData(@RequestBody @Valid SubProductDto subProductDto) {
		CustomResponse customResponse = subProductService.saveSubProduct(subProductDto);
		return new ResponseEntity<>(customResponse, HttpStatus.valueOf(customResponse.getStatus()));
	}
	
	@GetMapping("/getAll/subProduct/{parentProductId}")
	public ResponseEntity<?> getAllSubProductData(@PathVariable @Valid Long parentProductId) {
		SubProductAllDetailsDto customResponse = subProductService.getAllSubProduct(parentProductId);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

}
