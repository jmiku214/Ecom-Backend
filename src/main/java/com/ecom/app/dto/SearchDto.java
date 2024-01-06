package com.ecom.app.dto;

public class SearchDto {

	private Long subProductId;
	private Long sortType;

	public Long getSubProductId() {
		return subProductId;
	}

	public void setSubProductId(Long subProductId) {
		this.subProductId = subProductId;
	}

	public Long getSortType() {
		return sortType;
	}

	public void setSortType(Long sortType) {
		this.sortType = sortType;
	}

	public SearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
