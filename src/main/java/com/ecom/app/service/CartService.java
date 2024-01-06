package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.CartDto;

public interface CartService {

	CartDto saveCartDetails(CartDto cartDto);

	List<CartDto> getAllCartDetailsByUser(Long id);

	String deleteCartDetails(Long id);

	CartDto updateCart(CartDto cartDto);

}
