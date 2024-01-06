package com.ecom.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CartDto;
import com.ecom.app.dto.ProductDto;
import com.ecom.app.model.Cart;
import com.ecom.app.model.Product;
import com.ecom.app.repository.CartRepository;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public CartDto saveCartDetails(CartDto cartDto) {
		Cart cartSave = cartDto.convertDtoToCartEntity();
		Optional<Product> optionalProduct = productRepository.findById(cartDto.getProductId());
		Cart cartDB = cartRepository.findByUserIdAndProductId(cartDto.getUserId(), cartDto.getProductId());
		Double totalPrice = cartDto.getProductPrice() != null ? (cartDto.getProductPrice()) * cartDto.getTotalQuantity()
				: null;
		if (cartDB != null) {
//			cartSave.setTotalPrice(cartDB.getTotalPrice() + totalPrice);
//			cartSave.setTotalQuantity(cartDB.getTotalQuantity() + cartSave.getTotalQuantity());
//			cartSave.setId(cartDB.getId());
			throw new RuntimeException("Item already present in the cart !!!");
		} else {
			cartSave.setTotalPrice(totalPrice);
		}
		if (cartSave.getTotalQuantity() > optionalProduct.get().getAvailableStock()) {
			throw new RuntimeException("Unable to add that much quantity to cart !!!!");
		}
		CartDto cartDtoResponse = cartRepository.save(cartSave).convertEntityToCartDto();
		return cartDtoResponse;
	}

	@Override
	public List<CartDto> getAllCartDetailsByUser(Long id) {
		List<CartDto> cartDtoResponse = cartRepository.findByUserId(id).stream().map(e -> e.convertEntityToCartDto())
				.collect(Collectors.toList());
		return cartDtoResponse;
	}

	@Override
	public String deleteCartDetails(Long id) {

		cartRepository.deleteById(id);
		return "Successfully Deleted !!!";
	}

	@Override
	public CartDto updateCart(CartDto cartDto) {
		try {
			if (cartDto != null && cartDto.getId() != null) {
				Optional<Product> optionalProduct = productRepository.findById(cartDto.getProductId());
				if (cartDto.getTotalQuantity() > optionalProduct.get().getAvailableStock()) {
					throw new RuntimeException("Unable to add that much quantity to cart !!!!");
				}
				Cart cartSave = cartRepository.save(cartDto.convertDtoToCartEntity());
				return cartSave.convertEntityToCartDto();
			} else {
				throw new RuntimeException("Check you request!!!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
