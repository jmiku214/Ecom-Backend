package com.ecom.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecom.app.dto.CartDto;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product productId;
	private Long userId;
	private Integer totalQuantity;
	private Double totalPrice;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart(Long id, Product productId, Long userId, Integer totalQuantity, Double totalPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}

	public CartDto convertEntityToCartDto() {
		return new CartDto(this.getId(),
				this.getProductId() != null && this.getProductId().getId() != null ? this.getProductId().getId() : null,
				this.getProductId() != null && this.getProductId().getPrice() != null ? this.getProductId().getPrice()
						: null,
				this.getProductId() != null && this.getProductId().getProductName() != null
						? this.getProductId().getProductName()
						: null,
				this.getProductId() != null && this.getProductId().getImageUrl() != null
						? this.getProductId().getImageUrl()
						: null,
				this.getProductId() != null && this.getProductId().getModelName() != null
						? this.getProductId().getModelName()
						: null,
				this.getProductId() != null && this.getProductId().getAvailableStock() != null
						? this.getProductId().getAvailableStock()
						: null,
				this.getUserId(), this.getTotalQuantity(), this.getTotalPrice());
	}

}
