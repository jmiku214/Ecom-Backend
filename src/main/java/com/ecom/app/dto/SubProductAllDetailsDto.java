package com.ecom.app.dto;

import java.util.List;

import com.ecom.app.model.ParentProduct;

public class SubProductAllDetailsDto {

	private String parentProductName;

	private List<SubProductDto> subProductList;

	public SubProductAllDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getParentProductName() {
		return parentProductName;
	}

	public void setParentProductName(String parentProductName) {
		this.parentProductName = parentProductName;
	}

	public List<SubProductDto> getSubProductList() {
		return subProductList;
	}

	public void setSubProductList(List<SubProductDto> subProductList) {
		this.subProductList = subProductList;
	}

	public SubProductAllDetailsDto(String parentProductName, List<SubProductDto> subProductList) {
		super();
		this.parentProductName = parentProductName;
		this.subProductList = subProductList;
	}

}
