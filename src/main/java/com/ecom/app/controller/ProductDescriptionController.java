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

import com.ecom.app.dto.ProductDescriptionDto;
import com.ecom.app.security.ProductDescriptionService;
import com.ecom.app.service.CartService;

@RestController
public class ProductDescriptionController {

	@Autowired
	private ProductDescriptionService productDescriptionService;

	@PostMapping("add/productDescription")
	public ResponseEntity<?> saveCartData(@RequestBody @Valid ProductDescriptionDto productDescriptionDto) {
		ProductDescriptionDto response = productDescriptionService.saveProductDesc(productDescriptionDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
		
	@GetMapping("/getByUserId/productDescription/{productId}")
	public ResponseEntity<?> getCartById(@PathVariable @Valid Long productId) {
		ProductDescriptionDto customResponse = productDescriptionService.getAllProductDescription(productId);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
	
	@PutMapping("update/productDescription")
	public ResponseEntity<?> updateCartData(@RequestBody @Valid ProductDescriptionDto productDescriptionDto) {
		ProductDescriptionDto response = productDescriptionService.updateProductDesc(productDescriptionDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
