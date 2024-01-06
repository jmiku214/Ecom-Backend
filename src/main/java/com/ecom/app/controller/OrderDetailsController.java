package com.ecom.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.OrderDetailsDto;
import com.ecom.app.service.OrderDetailsService;
import com.ecom.app.serviceImpl.InvoiceGenerationServiceImpl;

@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	@Autowired
	private InvoiceGenerationServiceImpl invoiceGenerationServiceImpl;

	@PostMapping("add/order")
	public ResponseEntity<?> saveOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {
		OrderDetailsDto response = orderDetailsService.saveOrder(orderDetailsDto);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("generateinvoce/order/{id}")
	public ResponseEntity<?> genOrderDetails(@PathVariable Long id) throws Exception {
		CustomResponse response = invoiceGenerationServiceImpl.pdfGen(id);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("getAll/order/{userId}")
	public ResponseEntity<?> getAllOrderDetails(@PathVariable Long userId) {
		List<OrderDetailsDto> response = orderDetailsService.getAllOrder(userId);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PutMapping("update/order")
	public ResponseEntity<?> updateOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto,HttpServletRequest request) {
		
		System.err.println(request.getUserPrincipal());
		OrderDetailsDto response = orderDetailsService.updateOrder(orderDetailsDto, request);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("cancel/order/{orderId}/{productId}")
	public ResponseEntity<?> cancleOrderDetails(@PathVariable Long orderId,@PathVariable Long productId) {
		
		CustomResponse response = orderDetailsService.cancleOrder(orderId, productId);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
