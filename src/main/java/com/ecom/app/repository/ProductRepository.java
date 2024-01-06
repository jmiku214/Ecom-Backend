package com.ecom.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.Product;
import com.ecom.app.model.SubProduct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM ecom.product where model_name=?1", nativeQuery = true)
	List<Product> findByModelName(String modelName);

	@Query(value = "select * from product where sub_product_id=?1 order by(price) desc", nativeQuery = true)
	List<Product> findByIdAndDesc(Long subProductId);

	@Query(value = "select * from product where sub_product_id=?1 order by(price) asc", nativeQuery = true)
	List<Product> findByIdAndAsc(Long subProductId);

	@Modifying
	@Query(value="update product set available_stock=available_stock-1 where id=?1",nativeQuery = true)
	void removeFromAvailableStock(Long productId);
	
	@Modifying
	@Query(value="update product set available_stock=available_stock+1 where id=?1",nativeQuery = true)
	void addInAvailableStock(Long productId);
}
