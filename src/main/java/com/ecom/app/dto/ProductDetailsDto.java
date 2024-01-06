package com.ecom.app.dto;

import java.util.List;

public class ProductDetailsDto {

	private String subProductName;

	private Long id;

	private Long parentId;

	private String subProductImageUrl;

	private List<ProductDto> productList;

	public ProductDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public String getSubProductImageUrl() {
		return subProductImageUrl;
	}

	public void setSubProductImageUrl(String subProductImageUrl) {
		this.subProductImageUrl = subProductImageUrl;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

	public ProductDetailsDto(Long id, String subProductName, String subProductImageUrl, Long parentId,
			List<ProductDto> productList) {
		super();
		this.subProductName = subProductName;
		this.subProductImageUrl = subProductImageUrl;
		this.productList = productList;
		this.id = id;
		this.parentId = parentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
