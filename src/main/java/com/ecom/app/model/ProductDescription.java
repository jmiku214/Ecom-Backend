package com.ecom.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecom.app.dto.ProductDescriptionDto;

@Entity
@Table(name = "product_description")
public class ProductDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imageUrls;
	private String description;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product productId;

	public ProductDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDescription(Long id, String imageUrls, String description, Product productId) {
		super();
		this.id = id;
		this.imageUrls = imageUrls;
		this.description = description;
		this.productId = productId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public ProductDescriptionDto convertProductDescDto() {
		return new ProductDescriptionDto(this.getId(), this.getImageUrls(), this.getImageUrls().split(","),
				this.getDescription(),
				this.getProductId() != null && this.getProductId().getId() != null ? this.getProductId().getId()
						: null, this.getProductId().convertToProductDto());
	}

}
