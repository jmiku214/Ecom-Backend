package com.ecom.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.ProductDescription;

@Repository
public interface ProductDescriptionRepositroy extends JpaRepository<ProductDescription, Long>{

	@Query(value = "SELECT * FROM ecom.product_description where product_id=?1",nativeQuery = true)
	Optional<ProductDescription> findByProductId(Long productId);

}
