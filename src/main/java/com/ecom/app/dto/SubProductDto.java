package com.ecom.app.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ecom.app.model.ParentProduct;
import com.ecom.app.model.SubProduct;

public class SubProductDto {

	private Long id;

	@NotNull(message = "Brand name cannnot be null!!!")
	private String subProductName;

	@NotNull(message = "Brand image cannnot be null!!!")
	private String imageUrl;

	@NotNull(message = "Parent cannnot be null!!!")
	private Long parentProductId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getParentProductId() {
		return parentProductId;
	}

	public void setParentProductId(Long parentProductId) {
		this.parentProductId = parentProductId;
	}

	public SubProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubProductDto(Long id, String subProductName, String imageUrl, Long parentProductId) {
		super();
		this.id = id;
		this.subProductName = subProductName;
		this.imageUrl = imageUrl;
		this.parentProductId = parentProductId;
	}

	public SubProduct convertDtoToEntity() {
		return new SubProduct(this.getId(), this.getSubProductName(), this.getImageUrl(),new ParentProduct(this.getParentProductId()));
	}
	
}
