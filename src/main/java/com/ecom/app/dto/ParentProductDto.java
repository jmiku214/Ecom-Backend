package com.ecom.app.dto;

public class ParentProductDto {

	private Long id;
	private String productName;
	private String imageUrl;

	public ParentProductDto() {
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ParentProductDto(Long id, String productName, String imageUrl) {
		super();
		this.id = id;
		this.productName = productName;
		this.imageUrl = imageUrl;
	}

}
