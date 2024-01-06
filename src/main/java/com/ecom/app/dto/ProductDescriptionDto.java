package com.ecom.app.dto;

import com.ecom.app.model.Product;
import com.ecom.app.model.ProductDescription;

public class ProductDescriptionDto {

	private Long id;
	private String imageUrls;
	private String[] imageUrlList;
	private String description;
	private Long productId;
	private ProductDto product;

	public ProductDescriptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String[] getImageUrlList() {
		return imageUrlList;
	}

	public void setImageUrlList(String[] imageUrlList) {
		this.imageUrlList = imageUrlList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
	

	public ProductDescriptionDto(Long id, String imageUrls, String[] imageUrlList, String description, Long productId,
			ProductDto product) {
		super();
		this.id = id;
		this.imageUrls = imageUrls;
		this.imageUrlList = imageUrlList;
		this.description = description;
		this.productId = productId;
		this.product = product;
	}

	public ProductDescription convertToProductDescEntity() {
		return new ProductDescription(this.getId(), this.getImageUrls(), this.getDescription(),new Product(this.getProductId()));
	}

}
