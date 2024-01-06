package com.ecom.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.OrderDetailsDto;
import com.google.api.Authentication;

public interface OrderDetailsService {

	OrderDetailsDto saveOrder(OrderDetailsDto orderDetailsDto);

	List<OrderDetailsDto> getAllOrder(Long userId);

	OrderDetailsDto updateOrder(OrderDetailsDto orderDetailsDto, HttpServletRequest request);

	CustomResponse cancleOrder(Long orderId, Long productId);

}
