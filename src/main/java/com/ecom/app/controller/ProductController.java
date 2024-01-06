package com.ecom.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.ProductDetailsDto;
import com.ecom.app.dto.ProductDto;
import com.ecom.app.dto.SearchDto;
import com.ecom.app.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("add/product")
	public ResponseEntity<?> saveProductData(@RequestBody @Valid ProductDto productDto) {
		ProductDto response = productService.saveProduct(productDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll/product/{subProductId}")
	public ResponseEntity<?> getAllProductData(@PathVariable @Valid Long subProductId) {
		ProductDetailsDto customResponse = productService.getAllProductDetails(subProductId);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getById/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable @Valid Long id) {
		ProductDto customResponse = productService.productGetById(id);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
	@PostMapping("update/product")
	public ResponseEntity<?> updateProductData(@RequestBody @Valid ProductDto productDto) {
		ProductDto response = productService.updateProduct(productDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/product/{id}")
	public ResponseEntity<?> deleteProductData(@PathVariable Long id) {
		String response = productService.deleteProduct(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("getAll/sortBy/product")
	public ResponseEntity<?> sortProductData(@RequestBody @Valid SearchDto searchDto) {
		ProductDetailsDto response = productService.sortAllProducts(searchDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
