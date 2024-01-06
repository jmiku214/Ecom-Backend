package com.ecom.app.dto;

import com.ecom.app.model.Cart;
import com.ecom.app.model.Product;
import com.ecom.app.model.UserData;

public class CartDto {

	private Long id;
	private Long productId;
	private Double productPrice;
	private String productName;
	private String productImage;
	private String productModel;
	private Integer productAvailableStock;
	private Long userId;
	private Integer totalQuantity;
	private Double totalPrice;

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public Integer getProductAvailableStock() {
		return productAvailableStock;
	}

	public void setProductAvailableStock(Integer productAvailableStock) {
		this.productAvailableStock = productAvailableStock;
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

	public CartDto(Long id, Long productId, Double productPrice, String productName, String productImage,
			String productModel, Integer productAvailableStock, Long userId, Integer totalQuantity, Double totalPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productImage = productImage;
		this.productModel = productModel;
		this.productAvailableStock = productAvailableStock;
		this.userId = userId;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}

	public Cart convertDtoToCartEntity() {
		return new Cart(this.getId(), new Product(this.getProductId()), this.getUserId(), this.getTotalQuantity(),
				this.getTotalPrice());
	}

}
