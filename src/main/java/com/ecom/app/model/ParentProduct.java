package com.ecom.app.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecom.app.dto.ParentProductDto;
import com.ecom.app.dto.SubProductAllDetailsDto;

@Entity
@Table(name = "parent_product")
public class ParentProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "image_url")
	private String imageUrl;

	@OneToMany(mappedBy = "parentProductId", targetEntity = SubProduct.class)
	private List<SubProduct> subProducts;

	public ParentProduct(Long id) {
		this.id = id;
	}

	public ParentProduct() {
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

	public List<SubProduct> getSubProducts() {
		return subProducts;
	}

	public void setSubProducts(List<SubProduct> subProducts) {
		this.subProducts = subProducts;
	}
	
	public ParentProductDto convertToParentProductDto() {
		return new ParentProductDto(this.getId(), this.getProductName(), this.getImageUrl());
	}

	public SubProductAllDetailsDto convertToSubProductAllDetails() {
		return new SubProductAllDetailsDto(this.getProductName(),
				this.getSubProducts() != null
						? this.getSubProducts().stream().map(e -> e.convertEntityToDto()).collect(Collectors.toList())
						: null);
	}
}
