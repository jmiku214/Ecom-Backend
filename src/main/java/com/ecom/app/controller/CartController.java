package com.ecom.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.CartDto;
import com.ecom.app.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("add/cart")
	public ResponseEntity<?> saveCartData(@RequestBody @Valid CartDto cartDto) {
		CartDto response = cartService.saveCartDetails(cartDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
		
	@GetMapping("/getByUserId/cart/{id}")
	public ResponseEntity<?> getCartById(@PathVariable @Valid Long id) {
		List<CartDto> customResponse = cartService.getAllCartDetailsByUser(id);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
	
	@PutMapping("update/cart")
	public ResponseEntity<?> updateCartData(@RequestBody @Valid CartDto cartDto) {
		CartDto response = cartService.updateCart(cartDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/cart/{id}")
	public ResponseEntity<?> deleteCartData(@PathVariable Long id) {
		String response = cartService.deleteCartDetails(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
