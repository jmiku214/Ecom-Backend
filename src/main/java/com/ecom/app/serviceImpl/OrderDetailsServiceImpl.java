package com.ecom.app.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.OrderDetailsDto;
import com.ecom.app.enums.OrderStatus;
import com.ecom.app.model.Cart;
import com.ecom.app.model.OrderDetails;
import com.ecom.app.repository.CartRepository;
import com.ecom.app.repository.OrderDetailsRepository;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.service.OrderDetailsService;
import com.ecom.app.util.GenerateRandomCode;
import com.google.api.Authentication;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private InvoiceGenerationServiceImpl invoiceGenerationServiceImpl;

	@Transactional
	@Override
	public OrderDetailsDto saveOrder(OrderDetailsDto orderDetailsDto) {
		if (orderDetailsDto.getUserId() == null || orderDetailsDto.getUserId() == 0) {
			throw new RuntimeException("Please provide valid user!!!");
		}
		if (orderDetailsDto.getProductId() == null || orderDetailsDto.getProductId() == 0) {
			throw new RuntimeException("Please provide valid product!!!");
		}
		if (orderDetailsDto.getAddressId() == null || orderDetailsDto.getAddressId() == 0) {
			throw new RuntimeException("Please provide valid address!!!");
		}
		OrderDetails orderDetailsSave = orderDetailsDto.convertToOrderDetails();
		orderDetailsSave.setUuid(GenerateRandomCode.randomString(12).toUpperCase());
		orderDetailsSave.setCreatedOn(new Date());
		OrderDetailsDto orderDetailsResponse = orderDetailsRepository.save(orderDetailsSave).convertToOrderDetailsDto();
		if (orderDetailsResponse != null && orderDetailsResponse.getId() != null) {
			productRepository.removeFromAvailableStock(orderDetailsDto.getProductId());
		}
		Cart cartDetails = cartRepository.findByUserIdAndProductId(orderDetailsDto.getUserId(),
				orderDetailsDto.getProductId());
		if (cartDetails != null && cartDetails.getId() != null) {
			cartRepository.deleteById(cartDetails.getId());
		}

		return orderDetailsResponse;
	}

	@Override
	public List<OrderDetailsDto> getAllOrder(Long userId) {
		List<OrderDetails> orderDetailList = orderDetailsRepository.findAllByUserId(userId);
		List<OrderDetailsDto> orderDetailsResponse = orderDetailList.stream().map(e -> e.convertToOrderDetailsDtoV2())
				.collect(Collectors.toList());
		return orderDetailsResponse;
	}

	@Transactional
	@Override
	public OrderDetailsDto updateOrder(OrderDetailsDto orderDetailsDto, HttpServletRequest request) {
		System.out.println(request.getUserPrincipal().getName());
		Optional<OrderDetails> orderDetailsDB = orderDetailsRepository.findById(orderDetailsDto.getId());
		OrderDetails orderDetailsUpdate = orderDetailsDB.get();
		orderDetailsUpdate.setOrderStatus(orderDetailsDto.getOrderStatus());
		OrderDetailsDto orderDetailsResponse = orderDetailsRepository.save(orderDetailsUpdate)
				.convertToOrderDetailsDto();
		if (orderDetailsResponse != null && orderDetailsResponse.getId() != null
				&& orderDetailsDto.getOrderStatus().equals(OrderStatus.ORDER_CANCELLED_BY_USER)) {
			productRepository.addInAvailableStock(orderDetailsDto.getProductId());
		}

		return orderDetailsResponse;
	}

	@Transactional
	@Override
	public CustomResponse cancleOrder(Long orderId, Long productId) {
		OrderStatus orderStatus = OrderStatus.ORDER_CANCELLED_BY_USER;
		orderDetailsRepository.updateStatus(orderId, orderStatus.ordinal(),new Date());
		productRepository.addInAvailableStock(productId);

		return new CustomResponse(HttpStatus.OK.value(), null,"Order Cancled Successfully!!!");
	}

}
