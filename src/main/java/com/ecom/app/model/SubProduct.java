package com.ecom.app.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecom.app.dto.ProductDetailsDto;
import com.ecom.app.dto.SubProductDto;

@Entity
@Table(name = "sub_product")
public class SubProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sub_product_name")
	private String subProductName;

	@Column(name = "image_url")
	private String imageUrl;

	@OneToOne
	@JoinColumn(name = "parent_product_id")
	private ParentProduct parentProductId;

	@OneToMany(mappedBy = "subProductId", targetEntity = Product.class)
	private List<Product> productId;

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

	public ParentProduct getParentProductId() {
		return parentProductId;
	}

	public void setParentProductId(ParentProduct parentProductId) {
		this.parentProductId = parentProductId;
	}

	public List<Product> getProductId() {
		return productId;
	}

	public void setProductId(List<Product> productId) {
		this.productId = productId;
	}

	public SubProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubProduct(Long id, String subProductName, String imageUrl, ParentProduct parentProductId) {
		super();
		this.id = id;
		this.subProductName = subProductName;
		this.imageUrl = imageUrl;
		this.parentProductId = parentProductId;
	}

	public SubProduct(Long id) {
		this.id = id;
	}

	public SubProductDto convertEntityToDto() {
		return new SubProductDto(this.getId(), this.getSubProductName(), this.getImageUrl(),
				this.getParentProductId().getId());
	}

	public ProductDetailsDto convertToProductDetailsDto() {
		return new ProductDetailsDto(this.getId(), this.getSubProductName(), this.getImageUrl(),
				this.getParentProductId().getId(),
				this.getProductId() != null
						? this.getProductId().stream().map(e -> e.convertToProductDto()).collect(Collectors.toList())
						: null);
	}

}
