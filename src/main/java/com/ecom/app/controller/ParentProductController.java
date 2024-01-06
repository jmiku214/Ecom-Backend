package com.ecom.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.ParentProductDto;
import com.ecom.app.model.ParentProduct;
import com.ecom.app.service.ParentProductService;

@RestController
public class ParentProductController {

	@Autowired
	private ParentProductService productService;
	
	@GetMapping("/getAll/parent/product")
	public ResponseEntity<?> getAllParentProduct(){
		List<ParentProductDto> productData=productService.getAllParentProduct();
		return new ResponseEntity<>(productData,HttpStatus.OK);
	}
	
	@PostMapping("add/parent/product")
	public ResponseEntity<?> saveParentProductData(@RequestBody ParentProductDto parentProduct){
		ParentProduct product=productService.saveParentProduct(parentProduct);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
}
