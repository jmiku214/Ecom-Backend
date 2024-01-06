package com.ecom.app.dto;

import javax.validation.constraints.NotNull;

import com.ecom.app.model.Product;
import com.ecom.app.model.SubProduct;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

	private Long id;

	@NotNull(message = "Product Name cannot be null!!!")
	private String productName;

	@NotNull(message = "Model Name cannot be null!!!")
	private String modelName;

	@NotNull(message = "Price cannot be null!!!")
	private Double price;

	@NotNull(message = "Product Image cannot be null!!!")
	private String productImage;

	private Boolean isActive;

	@NotNull
	private Integer availableStock;

	@NotNull(message = "subProduct Id cannot be null!!!")
	private Long subProductId;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	public Long getSubProductId() {
		return subProductId;
	}

	public void setSubProductId(Long subProductId) {
		this.subProductId = subProductId;
	}

	public ProductDto(Long id, @NotNull(message = "Product Name cannot be null!!!") String productName,
			@NotNull(message = "Model Name cannot be null!!!") String modelName,
			@NotNull(message = "Price cannot be null!!!") Double price,
			@NotNull(message = "Product Image cannot be null!!!") String productImage, Boolean isActive,
			@NotNull Integer availableStock, @NotNull(message = "subProduct Id cannot be null!!!") Long subProductId) {
		super();
		this.id = id;
		this.productName = productName;
		this.modelName = modelName;
		this.price = price;
		this.productImage = productImage;
		this.isActive = isActive;
		this.availableStock = availableStock;
		this.subProductId = subProductId;
	}

	public Product convertToProductEntity() {
		return new Product(this.getId(), this.getProductName(), this.getModelName(), this.getPrice(),
				this.getProductImage(), this.getIsActive() != null ? this.getIsActive() : true,
				this.getAvailableStock(), new SubProduct(this.getSubProductId()));
	}

}
